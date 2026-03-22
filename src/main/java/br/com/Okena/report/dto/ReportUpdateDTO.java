package br.com.Okena.report.dto;

import br.com.Okena.report.entity.Categoria;
import br.com.Okena.usuarios.entity.Bairro;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ReportUpdateDTO(
        @NotNull
        Long id,
        String texto,
        String bairro,
        Long usuarioId,
        String categoria) {
}
