package br.com.Okena.domain.report.dto;

import java.time.LocalDateTime;

public record ReportResponseDTO(Long id,
                                String texto,
                                String categoria,
                                String bairro,
                                Double latitude,
                                Double longitude,
                                String usuario,
                                LocalDateTime data) {
}
