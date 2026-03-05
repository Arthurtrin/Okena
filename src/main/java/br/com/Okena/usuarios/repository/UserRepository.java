package br.com.Okena.usuarios.repository;

import br.com.Okena.usuarios.entity.Bairro;
import br.com.Okena.usuarios.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u.bairro FROM User u GROUP BY u.bairro ORDER BY COUNT(u) DESC LIMIT 1")
    Bairro bairroComMaisUsuario();

    @Query("SELECT u.bairro FROM User u GROUP BY u.bairro ORDER BY COUNT(u) ASC LIMIT 1")
    Bairro bairroComMenosUsuario();

    @Query("SELECT u.bairro FROM User u GROUP BY u.bairro ORDER BY COUNT(u) DESC")
    List<Bairro> bairrosEmUso();

    Optional<User> findById(Long usuarioId);
}
