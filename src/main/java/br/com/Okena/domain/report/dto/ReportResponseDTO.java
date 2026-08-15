package br.com.Okena.domain.report.dto;

import java.time.LocalDateTime;

public record ReportResponseDTO(Long id,
                                String texto,
                                String categoria,
                                Double latitude,
                                Double longitude,
                                String estado,
                                String cidade,
                                String bairro,
                                String logradouro,
                                String usuario,
                                LocalDateTime data) {
}
