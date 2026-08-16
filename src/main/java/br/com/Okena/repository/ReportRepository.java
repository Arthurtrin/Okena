package br.com.Okena.repository;

import br.com.Okena.domain.insight.dto.*;
import br.com.Okena.domain.report.Report;
import org.springframework.cglib.core.Local;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface ReportRepository extends JpaRepository<Report, Long> {
    List<Report> findByDataPostBetween(LocalDateTime inicio, LocalDateTime fim);
    Long countByDataPostBetween(LocalDateTime inicio, LocalDateTime fim);
    Long countByCategoria(String categoria);

    @Query("SELECT new br.com.Okena.domain.insight.dto.ReportPorCategoriaDTO(r.categoria, COUNT(r), 0.0) " +
            "FROM Report r GROUP BY r.categoria")
    List<ReportPorCategoriaDTO> contarAgrupadoPorCategoria();

    @Query("""
        SELECT new br.com.Okena.domain.insight.dto.EmAltaDTO(
            r.categoria,
            CONCAT(r.bairro, ' - ', r.cidade),
            COUNT(r)
        )
        FROM Report r
        GROUP BY r.categoria, r.bairro, r.cidade
        ORDER BY COUNT(r) DESC
    """)
    List<EmAltaDTO> buscarEmAlta(Pageable pageable);

    @Query("""
        SELECT new br.com.Okena.domain.insight.dto.EvolucaoTemporalDTO(
            extract(date from r.dataPost),
            COUNT(r)
        )
        FROM Report r
        WHERE r.dataPost >= :inicio
        GROUP BY extract(date from r.dataPost)
        ORDER BY extract(date from r.dataPost)
    """)
    List<EvolucaoTemporalDTO> evolucaoTemporal(
            @Param("inicio") LocalDateTime inicio
    );

    @Query("""
        SELECT new br.com.Okena.domain.insight.dto.CidadesComMaisOcorrenciasDTO(
            r.cidade,
            COUNT(r)
        )
        FROM Report r
        WHERE r.cidade IS NOT NULL
        GROUP BY r.cidade
        ORDER BY COUNT(r) DESC
    """)
    List<CidadesComMaisOcorrenciasDTO> buscarCidadesComMaisOcorrencias(Pageable pageable);


    @Query("""
        SELECT new br.com.Okena.domain.insight.dto.BairrosComMaisOcorrenciasDTO(
            r.bairro,
            r.cidade,
            COUNT(r)
        )
        FROM Report r
        WHERE r.bairro IS NOT NULL
          AND r.cidade IS NOT NULL
        GROUP BY r.bairro, r.cidade
        ORDER BY COUNT(r) DESC
    """)
    List<BairrosComMaisOcorrenciasDTO> buscarBairrosComMaisOcorrencias(Pageable pageable);
}
