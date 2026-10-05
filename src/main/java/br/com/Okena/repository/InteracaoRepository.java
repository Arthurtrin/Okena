package br.com.Okena.repository;

import br.com.Okena.domain.interacao.Interacao;
import br.com.Okena.domain.report.Report;
import br.com.Okena.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InteracaoRepository extends JpaRepository<Interacao, Long> {
    Optional<Interacao> findByUsuarioAndReport(User usuario, Report report);
}
