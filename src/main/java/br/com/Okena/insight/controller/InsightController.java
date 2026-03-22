package br.com.Okena.insight.controller;

import br.com.Okena.insight.service.InsightService;
import br.com.Okena.user.dto.UserInfoDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/insight")
public class InsightController {

    private final InsightService service;

    public InsightController(InsightService service){
        this.service = service;
    }

    @GetMapping("/bairros")
    public List<String> obterBairros(){
        return service.obterBairros();
    }

    @GetMapping("/categorias")
    public List<String> obterCategorias(){
        return service.obterCategorias();
    }

    @GetMapping("/informacoes")
    public UserInfoDTO info(){
        return service.userInfos();
    }
}
