package br.com.Okena.controller;

import br.com.Okena.domain.user.User;
import br.com.Okena.domain.user.dto.DetailsUser;
import br.com.Okena.domain.user.dto.UserRequestDTO;
import br.com.Okena.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/usuarios")
public class UserController {

    private final UserService service;

    public UserController(UserService service){
        this.service = service;
    }

    @GetMapping("/me")
    public ResponseEntity<DetailsUser> usuarioLogado(Authentication authentication) {
        String login = authentication.getName();
        User user = service.encontrarPorLogin(login);
        return ResponseEntity.ok(new DetailsUser(user));
    }

    @PostMapping()
    @Transactional
    public ResponseEntity<DetailsUser> criarUsuario(@RequestBody @Valid UserRequestDTO user, UriComponentsBuilder uriBuilder){
        return service.createUser(user, uriBuilder);
    }

}
