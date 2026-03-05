package br.com.Okena.report.dto;

import java.time.LocalDateTime;

public record ReportRespondeDTO(String texto,
                                String categoria,
                                String bairro,
                                String usuario,
                                LocalDateTime data) {
}
