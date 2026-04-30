package br.com.Okena.domain.bairro.dto;

import br.com.Okena.domain.bairro.Bairro;

public record BairroResponseDTO(
        Long id,
        String nome,
        Double latitude,
        Double longitude
) {

    public BairroResponseDTO(Bairro bairro){
        this(bairro.getId(), bairro.getNome(), bairro.getLatitude(), bairro.getLongitude());
    }
}
