package br.com.Okena.domain.report;


import lombok.Getter;

@Getter
public enum Categoria {
    ASSALTO("Assalto"),
    ILUMINACAO("Iluminação"),
    BURACO("Buraco"),
    ALAGAMENTO("Alagamento");

    private String categoria;

    Categoria(String categoria) {
        this.categoria = categoria;
    }

    public static Categoria fromString(String text) {
        for (Categoria categoria : Categoria.values()) {
            if (categoria.categoria.equalsIgnoreCase(text)) {
                return categoria;
            }
        }
        throw new IllegalArgumentException("Nenhuma categoria encontrada para a string fornecida: " + text);
    }

}
