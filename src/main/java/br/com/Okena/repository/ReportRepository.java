package br.com.Okena.repository;

import br.com.Okena.domain.bairro.Bairro;
import br.com.Okena.domain.report.Report;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<Report, Long> {

    Page<Report> findByBairro(Bairro bairro, Pageable page);
}
