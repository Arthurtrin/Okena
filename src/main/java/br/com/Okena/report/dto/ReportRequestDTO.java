package br.com.Okena.report.dto;

public record ReportRequestDTO(Long usuarioId,
                               String texto,
                               String categoria,
                               String bairro) {
}
