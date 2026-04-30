package br.com.Okena.controller;

import br.com.Okena.domain.user.dto.UserRequestDTO;
import br.com.Okena.service.UserService;
import jakarta.validation.Valid;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UserController {

    private final UserService service;

    public UserController(UserService service){
        this.service = service;
    }

    @PostMapping("/criar")
    @Transactional
    public void criarUsuario(@RequestBody @Valid UserRequestDTO user){
        service.criarUsuario(user);
    }

}
