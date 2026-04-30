package br.com.Okena.infra;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public record ErrorDTO(
        String mensagem,
        Integer status,
        LocalDateTime timestamp) {
}
