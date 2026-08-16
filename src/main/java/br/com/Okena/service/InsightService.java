package br.com.Okena.service;

import br.com.Okena.domain.insight.dto.*;
import br.com.Okena.domain.report.Categoria;
import br.com.Okena.repository.ReportRepository;
import br.com.Okena.repository.UserRepository;
import org.springframework.cglib.core.Local;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service
public class InsightService {

    private final UserRepository userRepository;
    private final ReportRepository reportRepository;


    // Injeção de dependencias
    public InsightService(ReportRepository reportRepository, UserRepository userRepository){
        this.userRepository = userRepository;
        this.reportRepository = reportRepository;
    }

    public InsigthDTO obterInsigths(){
        return new InsigthDTO(
                resumo(),
                reportPorCategoria(),
                evolucaoTemporal(),
                reportsEmAltaDTO(),
                buscarCidadesComMaisOcorrencias(),
                buscarBairrosComMaisOcorrencias());
    }

    public List<String> obterCategorias() {
        return Stream.of(Categoria.values()).map(Categoria::getCategoria).toList();
    }

    public List<ReportPorCategoriaDTO> reportPorCategoria() {
        Long totalReport = reportRepository.count();
        if (totalReport == 0) return List.of();

        // Busca todas as categorias e quantidades de uma só vez
        List<ReportPorCategoriaDTO> resultados = reportRepository.contarAgrupadoPorCategoria();

        // Apenas calcula o percentual na memória usando Streams
        return resultados.stream()
                .map(dto -> new ReportPorCategoriaDTO(
                        dto.categoria(),
                        dto.quantidade(),
                        ((double) dto.quantidade() / totalReport) * 100
                ))
                .toList();
    }

    public List<EmAltaDTO> reportsEmAltaDTO(){
        return reportRepository.buscarEmAlta(PageRequest.of(0, 3));
    }

    public List<EvolucaoTemporalDTO> evolucaoTemporal() {

        LocalDateTime inicio = LocalDate.now()
                .minusDays(6)
                .atStartOfDay();

        return reportRepository.evolucaoTemporal(inicio);
    }

    public List<CidadesComMaisOcorrenciasDTO> buscarCidadesComMaisOcorrencias() {
        return reportRepository.buscarCidadesComMaisOcorrencias(
                PageRequest.of(0, 5)
        );
    }

    public List<BairrosComMaisOcorrenciasDTO> buscarBairrosComMaisOcorrencias() {
        return reportRepository.buscarBairrosComMaisOcorrencias(
                PageRequest.of(0, 5)
        );
    }

    public ResumoDTO resumo(){
        Long total = reportRepository.count();

        LocalDateTime dataAtual = LocalDateTime.now();
        LocalDateTime data7DiasAntes =  dataAtual.minusDays(7);
        LocalDateTime data24Horas = dataAtual.minusHours(24);
        LocalDateTime data14DiasAntes = data7DiasAntes.minusDays(7);

        Long reportsPor14Dias = reportRepository.countByDataPostBetween(data14DiasAntes, data7DiasAntes);
        Long reportsPor7Dias = reportRepository.countByDataPostBetween(data7DiasAntes, dataAtual);
        Long reportPor24Horas = reportRepository.countByDataPostBetween(data24Horas, dataAtual);
        Double variacao = calcularVariacaoPercentual((double) reportsPor7Dias, (double) reportsPor14Dias);
        return new ResumoDTO(
                total,
                reportsPor7Dias,
                reportPor24Horas,
                BigDecimal.valueOf(variacao).setScale(2, java.math.RoundingMode.HALF_UP)
                        .doubleValue()
        );
    }

    private Double calcularVariacaoPercentual(Double reportsPor7Dias, Double reportsPor14Dias){
        // Evita erro de divisão por zero se o período anterior não teve cadastros
        if (reportsPor14Dias == 0) {
            return reportsPor7Dias > 0 ? 100.0 : 0.0;
        }

        return ((reportsPor7Dias - reportsPor14Dias) / reportsPor14Dias) * 100;
    }

//
//    public UserInfoDTO userInfos() {
//        return toDTO(userRepository.count(),
//                userRepository.bairroComMaisUsuario(),
//                userRepository.bairroComMenosUsuario(),
//                userRepository.bairrosEmUso());
//    }
//
//    private UserInfoDTO toDTO(long qtdUsuarios,
//                              Bairro bairroMaisUsuario,
//                              Bairro bairroMenosUsuario,
//                              List<Bairro> bairrosEmUso) {
//
//        return new UserInfoDTO(qtdUsuarios,
//                bairroMaisUsuario,
//                bairroMenosUsuario, bairrosEmUso);
//    }
}
