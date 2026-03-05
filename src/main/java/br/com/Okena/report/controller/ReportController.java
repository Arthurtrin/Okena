package br.com.Okena.report.controller;

import br.com.Okena.report.dto.ReportRequestDTO;
import br.com.Okena.report.dto.ReportRespondeDTO;
import br.com.Okena.report.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ReportService service;

    @PostMapping("/criar")
    public void criarReport(@RequestBody ReportRequestDTO dadosReport){
        service.criarReport(dadosReport);
    }

    @GetMapping
    public List<ReportRespondeDTO> obterReports(){
        return service.obterReports();
    }

    @GetMapping("/bairros")
    public List<String> obterBairros(){
        return service.obterBairros();
    }

    @GetMapping("/categorias")
    public List<String> obterCategorias(){
        return service.obterCategorias();
    }

    @GetMapping("/bairro/{bairro}")
    public ResponseEntity<?> obterBairros(@PathVariable String bairro){
        try {
            return ResponseEntity.ok(service.obterReportsPorBairro(bairro));
        }catch (IllegalArgumentException e){
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

}
