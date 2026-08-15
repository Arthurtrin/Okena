package br.com.Okena.service;

import br.com.Okena.domain.user.dto.DetailsUser;
import br.com.Okena.infra.error.exceptions.UserNotFoundException;
import br.com.Okena.domain.user.dto.UserRequestDTO;
import br.com.Okena.domain.user.User;
import br.com.Okena.repository.UserRepository;
import br.com.Okena.infra.security.PasswordHasher;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository repository){
        this.userRepository = repository;


    }

    public ResponseEntity<DetailsUser> createUser(UserRequestDTO userRequestDTO, UriComponentsBuilder uriBuilder){
        User user = fromDtoToUser(userRequestDTO);
        userRepository.save(user);
        var uri = uriBuilder.path("/usuarios/{id}")
                .buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri)
                .body(new DetailsUser(user));
    }

    private User fromDtoToUser(UserRequestDTO user){
        return new User(user.nome(),
                user.login(), user.email(),
                user.cpf(), PasswordHasher.hash(user.senha()));
    }

    public User encontrarUsuario(Long usuarioId){
        return userRepository.findById(usuarioId)
                .orElseThrow(() -> new UserNotFoundException(usuarioId));
    }

}
