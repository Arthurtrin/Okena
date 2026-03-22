package br.com.Okena.report.dto;

import jakarta.validation.constraints.NotNull;

public record ReportUpdateDTO(
        @NotNull
        Long id,
        String texto,
        String bairro,
        Long usuarioId,
        String categoria) {
}
