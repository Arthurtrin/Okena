package br.com.Okena.report.dto;

import br.com.Okena.bairro.dto.BairroResponseDTO;
import br.com.Okena.report.entity.Report;
import br.com.Okena.user.entity.User;

import java.time.LocalDateTime;

public record DetailsDTO(Long id,
                         LocalDateTime data,
                         String texto,
                         String categoria,
                         BairroResponseDTO bairro,
                         User usuario) {

    public DetailsDTO(Report report) {
        this(report.getId(),
                report.getDataPost(),
                report.getTexto(),
                report.getCategoria().getCategoria(),
                new BairroResponseDTO(report.getBairro()),
                report.getUsuario()
                );
    }
}
