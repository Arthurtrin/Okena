package br.com.Okena.bairro.dto;

public record BairroResponseDTO(
        Long id,
        String nome,
        Double latitude,
        Double longitude
) {
}
