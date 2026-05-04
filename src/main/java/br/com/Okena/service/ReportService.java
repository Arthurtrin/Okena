package br.com.Okena.service;

import br.com.Okena.domain.bairro.Bairro;
import br.com.Okena.domain.report.dto.DetailsDTO;
import br.com.Okena.domain.report.dto.ReportRequestDTO;
import br.com.Okena.domain.report.dto.ReportResponseDTO;
import br.com.Okena.domain.report.dto.ReportUpdateDTO;
import br.com.Okena.domain.report.Categoria;
import br.com.Okena.domain.report.Report;
import br.com.Okena.infra.error.exceptions.ReportNotFoundException;
import br.com.Okena.repository.ReportRepository;
import br.com.Okena.domain.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDateTime;

@Service
public class ReportService {

    private final ReportRepository reportRepository;
    private final UserService userService;
    private final BairroService bairroService;

    // Injeção de dependencias
    public ReportService(ReportRepository reportRepository,
                         UserService userService,
                         BairroService bairroService){
        this.reportRepository = reportRepository;
        this.userService = userService;
        this.bairroService = bairroService;
    }

    /* CRUD */
    //CREATE - recebe um DTO, tranforma em uma instancia de Report e salva no banco
    public ResponseEntity<DetailsDTO> createReport(ReportRequestDTO dadosReport, UriComponentsBuilder uriBuilder) {
        Report report = fromDtoToReport(dadosReport);
        reportRepository.save(report);
        var uri = uriBuilder.path("/medicos/{id}")
                .buildAndExpand(report.getId()).toUri();

        return ResponseEntity.created(uri)
                .body(new DetailsDTO(report));
    }

    //READ - Obter reports com paginação
    public ResponseEntity<Page<ReportResponseDTO>> obterReports(Pageable page) {
        Page<ReportResponseDTO> pageReport = reportRepository.findAll(page).map(this::fromReportToDTO);
        return ResponseEntity.ok(pageReport);
    }

    //UPDATE - atualiza report pelo id
    public ResponseEntity<DetailsDTO> updateReport(ReportUpdateDTO dados) {
        Report report = getById(dados.id());
        User user = null;
        Bairro bairro = bairroService.getBairroById(dados.bairroId());

        if(dados.usuarioId() != null)
            user = userService.encontrarUsuario(dados.usuarioId());

        report.updateReport(dados, user, bairro);
        return ResponseEntity.ok(new DetailsDTO(report));
    }

    //DELETE - Deleta report pelo id
    public ResponseEntity<Void> deletarReport(Long id) {
        if(reportRepository.existsById(id))
            reportRepository.deleteById(id);
        else
            throw new ReportNotFoundException(id);

        return ResponseEntity.noContent().build();
    }

    public Report getById(Long id){
        return reportRepository.findById(id)
                .orElseThrow(() -> new ReportNotFoundException(id));
    }

    /* UTILS */
    // Tranforma uma instancia da entidade Report em um DTO para listagem
    private ReportResponseDTO fromReportToDTO(Report r){
        return new ReportResponseDTO(
                r.getId(),
                r.getTexto(),
                r.getCategoria().getCategoria(),
                r.getBairro().getNome(),
                r.getUsuario() == null ? "anônimo" : r.getUsuario().getNomeDeUsuario(),
                r.getDataPost()
        );
    }

    // Transforma um DTO em uma instancia da entidade Report
    private Report fromDtoToReport(ReportRequestDTO dadosReport) {
        if (dadosReport.usuarioId() == null){
            return new Report(
                    dadosReport.texto(),
                    bairroService.getBairroById(dadosReport.bairroId()),
                    Categoria.fromString(dadosReport.categoria()),
                    LocalDateTime.now().withNano(0)
            );
        } else {
            return new Report(
                    userService.encontrarUsuario(dadosReport.usuarioId()),
                    dadosReport.texto(),
                    bairroService.getBairroById(dadosReport.bairroId()),
                    Categoria.fromString(dadosReport.categoria()),
                    LocalDateTime.now().withNano(0)
            );
        }
    }

    public Page<ReportResponseDTO> obterReportsPorBairro(Long bairroId, Pageable page) {
        Bairro bairro = bairroService.getBairroById(bairroId);
        return reportRepository.findByBairro(bairro, page).map(this::fromReportToDTO);
    }

}
