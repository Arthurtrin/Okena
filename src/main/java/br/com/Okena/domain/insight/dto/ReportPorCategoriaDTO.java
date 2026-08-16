package br.com.Okena.domain.insight.dto;

import br.com.Okena.domain.report.Categoria;

public record ReportPorCategoriaDTO(
        String categoria,
        Long quantidade,
        Double percentual
) {

    public ReportPorCategoriaDTO(Categoria categoria, Long quantidade, Double percentual) {
        this(categoria.getCategoria(), quantidade, percentual);
    }
}
