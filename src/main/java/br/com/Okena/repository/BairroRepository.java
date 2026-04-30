package br.com.Okena.repository;

import br.com.Okena.domain.bairro.Bairro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BairroRepository extends JpaRepository<Bairro, Long> {
}
