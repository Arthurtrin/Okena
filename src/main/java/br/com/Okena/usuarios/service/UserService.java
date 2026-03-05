package br.com.Okena.usuarios.service;

import br.com.Okena.usuarios.dto.UserDTO;
import br.com.Okena.usuarios.entity.Bairro;
import br.com.Okena.usuarios.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public UserDTO userInfos() {
        return toDTO(repository.count(),
                repository.bairroComMaisUsuario(),
                repository.bairroComMenosUsuario(),
                repository.bairrosEmUso());
    }

    private UserDTO toDTO(long qtdUsuarios,
                          Bairro bairroMaisUsuario,
                          Bairro bairroMenosUsuario,
                          List<Bairro> bairrosEmUso) {

        return new UserDTO(qtdUsuarios,
                bairroMaisUsuario,
                bairroMenosUsuario, bairrosEmUso);
    }




}
