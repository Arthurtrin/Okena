package br.com.Okena.service;

import br.com.Okena.domain.report.dto.*;
import br.com.Okena.domain.report.Categoria;
import br.com.Okena.domain.report.Report;
import br.com.Okena.domain.report.dto.address.NominatimResponseDTO;
import br.com.Okena.infra.error.exceptions.ReportNotFoundException;
import br.com.Okena.repository.ReportRepository;
import br.com.Okena.domain.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDateTime;

@Service
public class ReportService {

    private final ReportRepository reportRepository;
    private final UserService userService;
    private final GeocodingService geocodingService;

    public ReportService(
            ReportRepository reportRepository,
            UserService userService,
            GeocodingService geocodingService
    ) {
        this.reportRepository = reportRepository;
        this.userService = userService;
        this.geocodingService = geocodingService;
    }


    /* CREATE */

    public ResponseEntity<DetailsDTO> createReport(
            ReportRequestDTO dadosReport,
            UriComponentsBuilder uriBuilder,
            Authentication authentication
    ) {

        String login = authentication.getName();

        User usuario = userService.encontrarPorLogin(login);

        Report report = fromDtoToReport(
                dadosReport,
                usuario
        );

        reportRepository.save(report);

        var uri = uriBuilder
                .path("/report/{id}")
                .buildAndExpand(report.getId())
                .toUri();

        return ResponseEntity
                .created(uri)
                .body(new DetailsDTO(report));
    }


    /* READ */

    public ResponseEntity<Page<ReportResponseDTO>> obterReports(
            Pageable page
    ) {

        Page<ReportResponseDTO> pageReport =
                reportRepository
                        .findAll(page)
                        .map(this::fromReportToDTO);

        return ResponseEntity.ok(pageReport);
    }


    /* UPDATE */

    public ResponseEntity<DetailsDTO> updateReport(
            ReportUpdateDTO dados
    ) {

        Report report = getById(dados.id());

        User user = null;

        if (dados.usuarioId() != null) {
            user = userService.encontrarUsuario(
                    dados.usuarioId()
            );
        }

        report.updateReport(dados, user);

        return ResponseEntity.ok(
                new DetailsDTO(report)
        );
    }


    /* DELETE */

    public ResponseEntity<Void> deletarReport(Long id) {

        if (reportRepository.existsById(id)) {

            reportRepository.deleteById(id);

        } else {

            throw new ReportNotFoundException(id);

        }

        return ResponseEntity.noContent().build();
    }


    public Report getById(Long id) {

        return reportRepository
                .findById(id)
                .orElseThrow(
                        () -> new ReportNotFoundException(id)
                );
    }


    /* UTILS */

    private ReportResponseDTO fromReportToDTO(Report r) {

        String autor = r.isAnonimo()
                ? "anônimo"
                : r.getUsuario().getLogin();

        return new ReportResponseDTO(
                r.getId(),
                r.getTexto(),
                r.getCategoria().getCategoria(),
                r.getLatitude(),
                r.getLongitude(),
                r.getEstado(),
                r.getCidade(),
                r.getBairro(),
                r.getLogradouro(),
                autor,
                r.isAnonimo(),
                r.getDataPost()
        );
    }


    private Report fromDtoToReport(
            ReportRequestDTO dadosReport,
            User usuario
    ) {

        NominatimResponseDTO enderecoDTO =
                geocodingService.buscarEndereco(
                        dadosReport.latitude(),
                        dadosReport.longitude()
                );

        return new Report(
                usuario,
                dadosReport.anonimo(),
                dadosReport.texto(),
                enderecoDTO.address().estado(),
                enderecoDTO.address().cidade(),
                enderecoDTO.address().bairro(),
                enderecoDTO.address().logradouro(),
                dadosReport.latitude(),
                dadosReport.longitude(),
                Categoria.fromString(
                        dadosReport.categoria()
                ),
                LocalDateTime.now().withNano(0)
        );
    }
}