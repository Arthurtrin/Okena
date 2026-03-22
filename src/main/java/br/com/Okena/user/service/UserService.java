package br.com.Okena.user.service;

import br.com.Okena.user.dto.UserInfoDTO;
import br.com.Okena.user.dto.UserRequestDTO;
import br.com.Okena.user.entity.Bairro;
import br.com.Okena.user.entity.User;
import br.com.Okena.user.repository.UserRepository;
import br.com.Okena.security.PasswordHasher;
import org.springframework.stereotype.Service;

import java.util.List;

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
                .orElseThrow(() -> new RuntimeException("usuario não encontrado"));
    }

}
