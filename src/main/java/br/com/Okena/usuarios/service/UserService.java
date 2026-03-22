package br.com.Okena.usuarios.service;

import br.com.Okena.usuarios.dto.UserInfoDTO;
import br.com.Okena.usuarios.dto.UserRequestDTO;
import br.com.Okena.usuarios.entity.Bairro;
import br.com.Okena.usuarios.entity.User;
import br.com.Okena.usuarios.repository.UserRepository;
import br.com.Okena.usuarios.security.PasswordHasher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository){
        this.repository = repository;
    }

    public UserInfoDTO userInfos() {
        return toDTO(repository.count(),
                repository.bairroComMaisUsuario(),
                repository.bairroComMenosUsuario(),
                repository.bairrosEmUso());
    }

    private UserInfoDTO toDTO(long qtdUsuarios,
                              Bairro bairroMaisUsuario,
                              Bairro bairroMenosUsuario,
                              List<Bairro> bairrosEmUso) {

        return new UserInfoDTO(qtdUsuarios,
                bairroMaisUsuario,
                bairroMenosUsuario, bairrosEmUso);
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
