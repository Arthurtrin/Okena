package br.com.Okena.domain.insight.dto;

import br.com.Okena.domain.report.Categoria;

public record EmAltaDTO(
        String categoria,
        String local,
        Long quantidade
) {

    public EmAltaDTO(Categoria categoria, String local, Long quantidade){
        this(categoria.getCategoria(), local, quantidade);
    }

}
