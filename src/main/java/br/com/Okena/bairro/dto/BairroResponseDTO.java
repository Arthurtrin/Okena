package br.com.Okena.bairro.dto;

import br.com.Okena.bairro.entity.Bairro;

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
