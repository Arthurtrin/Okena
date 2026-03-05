package br.com.Okena.usuarios.controller;

import br.com.Okena.usuarios.dto.UserDTO;
import br.com.Okena.usuarios.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/informacoes")
    public UserDTO info(){
        return service.userInfos();
    }
}
