package br.com.Okena.domain.bairro.dto;

import jakarta.validation.constraints.NotNull;

public record BairroUpdateDTO(
        @NotNull
        Long id,
        String nome,
        Double latitude,
        Double longitude

) {
}
