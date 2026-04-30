package br.com.Okena.domain.report.dto;

import java.time.LocalDateTime;

public record ReportResponseDTO(Long id,
                                String texto,
                                String categoria,
                                String bairro,
                                String usuario,
                                LocalDateTime data) {
}
