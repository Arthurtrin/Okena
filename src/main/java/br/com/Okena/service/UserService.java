package br.com.Okena.service;

import br.com.Okena.infra.error.exceptions.UserNotFoundException;
import br.com.Okena.domain.user.dto.UserRequestDTO;
import br.com.Okena.domain.user.Bairro;
import br.com.Okena.domain.user.User;
import br.com.Okena.repository.UserRepository;
import br.com.Okena.infra.security.PasswordHasher;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository){
        this.repository = repository;
    }

    public void criarUsuario(UserRequestDTO user) {
        repository.save(fromRequestDtoToUser(user));
    }

    private User fromRequestDtoToUser(UserRequestDTO user){
        return new User(user.nome(),
                user.nomeDeUsuario(), Bairro.fromString(user.bairro()), user.email(),
                user.cpf(), PasswordHasher.hash(user.senha()));
    }

    public User encontrarUsuario(Long usuarioId){
        return repository.findById(usuarioId)
                .orElseThrow(() -> new UserNotFoundException(usuarioId));
    }

}
