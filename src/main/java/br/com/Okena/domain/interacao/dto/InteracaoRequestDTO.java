package br.com.Okena.domain.interacao.dto;

public record InteracaoRequestDTO(
        Long usuario,
        Long report,
        String categoria

) {
}
