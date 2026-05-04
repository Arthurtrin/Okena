package br.com.Okena.domain.bairro.dto;

import jakarta.validation.constraints.NotBlank;


public record BairroRequestDTO(
        @NotBlank(message = "{bairro.obrigatorio}")
        String nome,
        Double latitude,
        Double longitude
) {
}
