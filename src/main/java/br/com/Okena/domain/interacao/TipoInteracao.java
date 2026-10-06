package br.com.Okena.domain.interacao;

import lombok.Getter;

@Getter
public enum TipoInteracao {
    CONFIRMAR("confirmar"),
    CONTESTAR("contestar"),
    APROVAR("aprovar");

    private String tipo;

    TipoInteracao(String tipo) {
        this.tipo = tipo;
    }

    public static TipoInteracao fromString(String text) {
        for (TipoInteracao tipo : TipoInteracao.values()) {
            if (tipo.tipo.equalsIgnoreCase(text)) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Nenhuma categoria encontrada para a string fornecida: " + text);
    }

}
