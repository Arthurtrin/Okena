package br.com.Okena.infra.exceptions;

import br.com.Okena.bairro.entity.Bairro;

public class BairroNotFoundException extends RuntimeException {
    public BairroNotFoundException(String message) {
        super(message);
    }

    public BairroNotFoundException(Long id){
        super("Bairro de id " + id + " não encontado.");
    }
}
