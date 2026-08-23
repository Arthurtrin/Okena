package br.com.Okena.domain.report.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ReportRequestDTO(

        boolean anonimo,
        Double latitude,
        Double longitude,
        @NotBlank(message = "{texto.obrigatorio}")
        String texto,
        @NotBlank(message = "{categoria.obrigatorio}")
        String categoria
        ) {
}
