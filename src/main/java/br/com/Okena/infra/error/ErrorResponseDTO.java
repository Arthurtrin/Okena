package br.com.Okena.infra.error;

import java.time.LocalDateTime;

public record ErrorResponseDTO(
        String mensagem,
        Integer status,
        LocalDateTime timestamp) {
}
