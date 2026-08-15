package br.com.Okena.domain.report.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ReportRequestDTO(

        Long usuarioId,
        Double latitude,
        Double longitude,
        @NotBlank(message = "{texto.obrigatorio}")
        String texto,
        @NotBlank(message = "{categoria.obrigatorio}")
        String categoria
        ) {
}
