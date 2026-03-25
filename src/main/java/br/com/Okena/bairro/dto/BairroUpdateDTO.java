package br.com.Okena.bairro.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record BairroUpdateDTO(
        @NotNull
        Long id,
        String nome,
        Double latitude,
        Double longitude

) {
}
