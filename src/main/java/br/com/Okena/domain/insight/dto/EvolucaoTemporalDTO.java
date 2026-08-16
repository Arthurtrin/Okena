package br.com.Okena.domain.insight.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record EvolucaoTemporalDTO(
        LocalDate data,
        Long quantidade
) {
}
