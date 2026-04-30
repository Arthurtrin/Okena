package br.com.Okena.report.repository;

import br.com.Okena.bairro.entity.Bairro;
import br.com.Okena.report.entity.Report;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReportRepository extends JpaRepository<Report, Long> {

    Page<Report> findByBairro(Bairro bairro, Pageable page);
}
