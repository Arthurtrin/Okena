package br.com.Okena.report.dto;

import java.time.LocalDateTime;

public record ReportRespondeDTO(Long id,
                                String texto,
                                String categoria,
                                String bairro,
                                String usuario,
                                LocalDateTime data) {
}
