package br.com.Okena.infra.error.exceptions;

public class BairroNotFoundException extends RuntimeException {
    public BairroNotFoundException(String message) {
        super(message);
    }

    public BairroNotFoundException(Long id){
        super("Bairro de id " + id + " não encontado.");
    }
}
