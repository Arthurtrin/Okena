package br.com.Okena.report.repository;

import br.com.Okena.report.entity.Report;
import br.com.Okena.usuarios.entity.Bairro;
import br.com.Okena.usuarios.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ReportRepository extends JpaRepository<Report, Long> {

    @Query("SELECT r FROM Report r ORDER BY r.dataPost DESC")
    List<Report> findAllOrderByDataPost();

    List<Report> findByBairroOrderByDataPostDesc(Bairro bairro);

}
