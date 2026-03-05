package br.com.Okena.report.dto;

import java.time.LocalDateTime;

public record ReportRequestDTO(Long usuarioId,
                               String texto,
                               String categoria,
                               String bairro) {
}
