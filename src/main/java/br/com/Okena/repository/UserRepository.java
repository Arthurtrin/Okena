package br.com.Okena.repository;

import br.com.Okena.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findById(Long usuarioId);
    UserDetails findByLogin(String username);
    Optional<User> findUserByLogin(String login);
}
