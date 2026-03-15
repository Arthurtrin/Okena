package br.com.Okena.report.service;

import br.com.Okena.report.dto.ReportRequestDTO;
import br.com.Okena.report.dto.ReportRespondeDTO;
import br.com.Okena.report.entity.Categoria;
import br.com.Okena.report.entity.Report;
import br.com.Okena.report.repository.ReportRepository;
import br.com.Okena.usuarios.entity.Bairro;
import br.com.Okena.usuarios.entity.User;
import br.com.Okena.usuarios.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Stream;

@Service
public class ReportService {

    @Autowired
    private ReportRepository repository;

    @Autowired
    private UserRepository userRepository;

    public Page<ReportRespondeDTO> obterReports(Pageable page) {
        return repository.findAll(page).map(this::fromListToDTO);
    }

    private ReportRespondeDTO fromListToDTO(Report r){
        return new ReportRespondeDTO(
                r.getTexto(),
                r.getCategoria().getCategoria(),
                r.getBairro().getBairro(),
                r.getUsuario() == null ? "anônimo" : r.getUsuario().getNomeDeUsuario(),
                r.getDataPost()
        );
    }

    public List<String> obterBairros() {
        return Stream.of(Bairro.values()).map(Bairro::getBairro).toList();
    }

    public List<String> obterCategorias() {
        return Stream.of(Categoria.values()).map(Categoria::getCategoria).toList();
    }

    public List<ReportRespondeDTO> obterReportsPorBairro(String bairro) {
        return repository.findByBairroOrderByDataPostDesc(Bairro.fromString(bairro)).stream()
                .map(this::fromListToDTO).toList();
    }

    public void criarReport(ReportRequestDTO dadosReport) {
        repository.save(fromDtoToReport(dadosReport));
    }

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
                    encontrarUsuario(dadosReport.usuarioId()),
                    dadosReport.texto(),
                    Bairro.fromString(dadosReport.bairro()),
                    Categoria.fromString(dadosReport.categoria()),
                    LocalDateTime.now().withNano(0)
            );
        }
    }

    private User encontrarUsuario(Long usuarioId){
        return userRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("usuario não encontrado"));
    }
}
