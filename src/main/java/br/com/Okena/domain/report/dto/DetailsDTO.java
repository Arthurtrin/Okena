package br.com.Okena.domain.report.dto;

import br.com.Okena.domain.report.Report;
import br.com.Okena.domain.user.User;

import java.time.LocalDateTime;

public record DetailsDTO(Long id,
                         LocalDateTime data,
                         String texto,
                         String categoria,
                         User usuario) {

    public DetailsDTO(Report report) {
        this(report.getId(),
                report.getDataPost(),
                report.getTexto(),
                report.getCategoria().getCategoria(),
                report.getUsuario()
                );
    }
}
