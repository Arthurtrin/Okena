package br.com.Okena.controller;

import br.com.Okena.domain.interacao.dto.InteracaoRequestDTO;
import br.com.Okena.service.InteracaoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/interacao")
public class InteracaoController {

    private final InteracaoService interacaoService;

    public InteracaoController(InteracaoService service){
        this.interacaoService = service;
    }

    @PostMapping
    public ResponseEntity<?> createInteracao(@RequestBody @Valid InteracaoRequestDTO interacaoRequestDTO){
        interacaoService.interagir(interacaoRequestDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}
