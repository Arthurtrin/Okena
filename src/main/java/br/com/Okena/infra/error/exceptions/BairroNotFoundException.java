package br.com.Okena.infra.error.exceptions;

public class BairroNotFoundException extends ResourceNotFoundException {

    public BairroNotFoundException(Long id){
        super("Bairro de id " + id + " não encontado.");
    }
}
