package br.com.Okena.report.controller;

import br.com.Okena.report.dto.ReportRequestDTO;
import br.com.Okena.report.dto.ReportRespondeDTO;
import br.com.Okena.report.dto.ReportUpdateDTO;
import br.com.Okena.report.service.ReportService;
import jakarta.persistence.PostUpdate;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/report")
public class ReportController {

    private final ReportService service;

    public ReportController(ReportService service){
        this.service = service;
    }

    // READ
    @GetMapping
    public Page<ReportRespondeDTO> obterReports(@PageableDefault(size = 5, sort = {"dataPost"}) Pageable page){
        return service.obterReports(page);
    }

    // CREATE
    @PostMapping()
    @Transactional
    public void criarReport(@RequestBody @Valid ReportRequestDTO dadosReport){
        service.criarReport(dadosReport);
    }

    //Update
    @PutMapping
    @Transactional
    public void editarReport(@RequestBody ReportUpdateDTO reportUpdateDTO){
        service.updateReport(reportUpdateDTO);
    }

    // DELETE
    @DeleteMapping("/{id}")
    @Transactional
    public void deletarReport(@PathVariable Long id){
        service.deletarReport(id);
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
    public ResponseEntity<?> obterReportPorBairro(@PathVariable String bairro){
        try {
            return ResponseEntity.ok(service.obterReportsPorBairro(bairro));
        }catch (IllegalArgumentException e){
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

}
