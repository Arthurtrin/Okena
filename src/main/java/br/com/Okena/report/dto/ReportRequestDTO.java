package br.com.Okena.report.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ReportRequestDTO(
        @NotNull
        Long usuarioId,
        @NotBlank
        String texto,
        @NotBlank
        String categoria,
        @NotBlank
        String bairro) {
}
