package br.com.Okena.bairro.dto;

import jakarta.validation.constraints.NotBlank;


public record BairroRequestDTO(
        @NotBlank
        String nome,
        Double latitude,
        Double longitude
) {
}
