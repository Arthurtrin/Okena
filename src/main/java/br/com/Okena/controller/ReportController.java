package br.com.Okena.controller;

import br.com.Okena.domain.report.dto.DetailsDTO;
import br.com.Okena.domain.report.dto.ReportRequestDTO;
import br.com.Okena.domain.report.dto.ReportResponseDTO;
import br.com.Okena.domain.report.dto.ReportUpdateDTO;
import br.com.Okena.service.ReportService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("/report")
public class ReportController {

    private final ReportService service;

    public ReportController(ReportService service){
        this.service = service;
    }

    // READ
    @GetMapping
    public ResponseEntity<Page<ReportResponseDTO>> obterReports(@PageableDefault(size =30, sort = "dataPost", direction = Sort.Direction.DESC) Pageable page){
        return service.obterReports(page);
    }

    // CREATE
    @PostMapping()
    @Transactional
    public ResponseEntity<DetailsDTO> criarReport(@RequestBody @Valid ReportRequestDTO dadosReport, UriComponentsBuilder uriBuilder){
        return service.createReport(dadosReport, uriBuilder);
    }

    //Update
    @PutMapping
    @Transactional
    public ResponseEntity<DetailsDTO> editarReport(@RequestBody @Valid ReportUpdateDTO reportUpdateDTO){
        return service.updateReport(reportUpdateDTO);
    }

    // DELETE
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> deletarReport(@PathVariable Long id){
        return service.deletarReport(id);
    }

    /*@GetMapping("/bairro/{bairroId}")
    public Page<ReportResponseDTO> obterReportPorBairro(@PathVariable Long bairroId,
                                                        @PageableDefault(
                                                                size = 5,
                                                                sort = "dataPost",
                                                                direction = Sort.Direction.DESC)
                                                        Pageable page){
        return service.obterReportsPorBairro(bairroId, page);
    }*/

}
