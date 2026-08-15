package br.com.Okena.domain.report.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ReportUpdateDTO(
        @NotNull
        Long id,
        @NotBlank(message = "{texto.obrigatorio}")
        String texto,
        Long usuarioId,
        @NotBlank(message = "{categoria.obrigatorio}")
        String categoria) {
}
