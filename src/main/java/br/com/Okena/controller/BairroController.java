package br.com.Okena.controller;


import br.com.Okena.domain.bairro.dto.BairroRequestDTO;
import br.com.Okena.domain.bairro.dto.BairroResponseDTO;
import br.com.Okena.domain.bairro.dto.BairroUpdateDTO;
import br.com.Okena.service.BairroService;

import jakarta.validation.Valid;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bairro")
public class BairroController {

    private final BairroService bairroService;

    public BairroController(BairroService bairroService){
        this.bairroService = bairroService;
    }

    @GetMapping()
    public List<BairroResponseDTO> obterBairros(){
        return bairroService.obterBairros();
    }

    @GetMapping("/{id}")
    public BairroResponseDTO obterBairro(@PathVariable Long id){
        return bairroService.getById(id);
    }

    @PostMapping()
    @Transactional
    public void addBairro(@RequestBody @Valid BairroRequestDTO dados){
        bairroService.addBairro(dados);
    }

    @PutMapping()
    @Transactional
    public void updateBairro(@RequestBody @Valid BairroUpdateDTO dados){
        bairroService.updateBairro(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deleteBairro(@PathVariable Long id){
        bairroService.deleteBairro(id);
    }



}
