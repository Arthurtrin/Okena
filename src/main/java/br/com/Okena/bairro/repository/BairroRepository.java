package br.com.Okena.bairro.repository;

import br.com.Okena.bairro.entity.Bairro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BairroRepository extends JpaRepository<Bairro, Long> {
}
