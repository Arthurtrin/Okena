package br.com.Okena.infra.error;

import java.time.LocalDateTime;

public record ErrorDTO(
        String mensagem,
        Integer status,
        LocalDateTime timestamp) {
}
