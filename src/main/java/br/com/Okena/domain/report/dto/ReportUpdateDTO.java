package br.com.Okena.domain.report.dto;

import jakarta.validation.constraints.NotNull;

public record ReportUpdateDTO(
        @NotNull
        Long id,
        String texto,
        @NotNull
        Long bairroId,
        Long usuarioId,
        String categoria) {
}
