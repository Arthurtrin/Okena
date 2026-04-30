package br.com.Okena.report.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ReportRequestDTO(

        Long usuarioId,
        @NotNull
        Long bairroId,
        @NotBlank
        String texto,
        @NotBlank
        String categoria
        ) {
}
