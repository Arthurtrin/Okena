package br.com.Okena.service;

import br.com.Okena.domain.interacao.Interacao;
import br.com.Okena.domain.interacao.TipoInteracao;
import br.com.Okena.domain.interacao.dto.InteracaoRequestDTO;
import br.com.Okena.domain.report.Report;
import br.com.Okena.domain.user.User;
import br.com.Okena.repository.InteracaoRepository;
import br.com.Okena.repository.ReportRepository;
import br.com.Okena.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.function.Consumer;

@Service
public class InteracaoService {

    private final InteracaoRepository interacaoRepository;
    private UserRepository userRepository;
    private ReportRepository reportRepository;

    public InteracaoService(
            InteracaoRepository interacaoRepository,
            UserRepository userRepository,
            ReportRepository reportRepository) {
        this.interacaoRepository = interacaoRepository;
        this.userRepository = userRepository;
        this.reportRepository = reportRepository;
    }

    @Transactional
    public void interagir(InteracaoRequestDTO interacaoRequestDTO) {

        Report report = reportRepository
                .findById(interacaoRequestDTO.report())
                .orElseThrow();
        User usuario = userRepository.findById(interacaoRequestDTO.usuario()).orElseThrow();

        Optional<Interacao> interacao = interacaoRepository
                .findByUsuarioAndReport(
                        usuario,
                        report
                );

        TipoInteracao tipoNovo = TipoInteracao
                .fromString(interacaoRequestDTO.tipo());


        if (interacao.isPresent()) {

            Interacao interacaoExiste = interacao.get();

            TipoInteracao tipoAntigo = interacaoExiste.getTipoInteracao();

            if (tipoAntigo != tipoNovo) {
                subInteragir(tipoAntigo, report);
                addInteragir(tipoNovo, report);

                interacaoExiste.setTipoInteracao(tipoNovo);
                interacaoExiste.setDataInteracao(LocalDateTime.now());
            }

        } else {

            interacaoRepository.save(
                    new Interacao(
                            usuario,
                            report,
                            tipoNovo,
                            LocalDateTime.now()
                    )
            );
            addInteragir(tipoNovo, report);
        }
    }

    public void subInteragir(TipoInteracao tipo, Report report){
        if (tipo == TipoInteracao.APROVAR) {
            report.setAprovacoes(report.getAprovacoes() - 1);

        } else if (tipo == TipoInteracao.CONTESTAR) {
            report.setContestacoes(report.getContestacoes() - 1);

        } else if (tipo == TipoInteracao.CONFIRMAR) {
            report.setConfirmacoes(report.getConfirmacoes() - 1);
        }
    }

    public void addInteragir(TipoInteracao tipo, Report report){
        if (tipo == TipoInteracao.APROVAR) {
            report.setAprovacoes(report.getAprovacoes() + 1);

        } else if (tipo == TipoInteracao.CONTESTAR) {
            report.setContestacoes(report.getContestacoes() + 1);

        } else if (tipo == TipoInteracao.CONFIRMAR) {
            report.setConfirmacoes(report.getConfirmacoes() + 1);
        }
    }






}
