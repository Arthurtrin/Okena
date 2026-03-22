package br.com.Okena.report.service;

import br.com.Okena.report.dto.ReportRequestDTO;
import br.com.Okena.report.dto.ReportRespondeDTO;
import br.com.Okena.report.dto.ReportUpdateDTO;
import br.com.Okena.report.entity.Categoria;
import br.com.Okena.report.entity.Report;
import br.com.Okena.report.repository.ReportRepository;
import br.com.Okena.user.entity.Bairro;
import br.com.Okena.user.entity.User;
import br.com.Okena.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Stream;

@Service
public class ReportService {

    private final ReportRepository reportRepository;
    private final UserService userService;

    // Injeção de dependencias
    public ReportService(ReportRepository reportRepository, UserService userService){
        this.reportRepository = reportRepository;
        this.userService = userService;
    }

    /* CRUD */
    //CREATE - recebe um DTO, tranforma em uma instancia de Report e salva no banco
    public void criarReport(ReportRequestDTO dadosReport) {
        reportRepository.save(fromDtoToReport(dadosReport));
    }

    //READ - Obter reports com paginação
    public Page<ReportRespondeDTO> obterReports(Pageable page) {
        return reportRepository.findAll(page).map(this::fromListToDTO);
    }

    //UPDATE - atualiza report pelo id
    public void updateReport(@Valid ReportUpdateDTO dados) {
        var report = reportRepository.getReferenceById(dados.id());
        User user = null;
        if(dados.usuarioId() != null){
            try{
                user = userService.encontrarUsuario(dados.usuarioId());
            } catch (RuntimeException e){
                System.out.println("erro: " + e.getMessage());
            }
        }
        report.updateReport(dados, user);
    }

    //DELETE - Deleta report pelo id
    public void deletarReport(Long id) {
        if(reportRepository.existsById(id)){
            reportRepository.deleteById(id);
        } else{
            // tratar como excessão mais pra frente
            System.out.println("id não encontrado");
        }
    }

    /* UTILS */
    // Tranforma uma instancia da entidade Report em um DTO para listagem
    private ReportRespondeDTO fromListToDTO(Report r){
        return new ReportRespondeDTO(
                r.getId(),
                r.getTexto(),
                r.getCategoria().getCategoria(),
                r.getBairro().getBairro(),
                r.getUsuario() == null ? "anônimo" : r.getUsuario().getNomeDeUsuario(),
                r.getDataPost()
        );
    }

    // Transforma um DTO em uma instancia da entidade Report
    private Report fromDtoToReport(ReportRequestDTO dadosReport) {
        if (dadosReport.usuarioId() == null){
            return new Report(
                    dadosReport.texto(),
                    Bairro.fromString(dadosReport.bairro()),
                    Categoria.fromString(dadosReport.categoria()),
                    LocalDateTime.now().withNano(0)
            );
        } else {
            return new Report(
                    userService.encontrarUsuario(dadosReport.usuarioId()),
                    dadosReport.texto(),
                    Bairro.fromString(dadosReport.bairro()),
                    Categoria.fromString(dadosReport.categoria()),
                    LocalDateTime.now().withNano(0)
            );
        }
    }

    public List<ReportRespondeDTO> obterReportsPorBairro(String bairro) {
        return reportRepository.findByBairroOrderByDataPostDesc(Bairro.fromString(bairro)).stream()
                .map(this::fromListToDTO).toList();
    }

}
