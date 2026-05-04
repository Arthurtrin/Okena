package br.com.Okena.infra.error.exceptions;

public class UserNotFoundException extends ResourceNotFoundException {

    public UserNotFoundException(Long id){
        super("Usuário de id " + id + " não econtrado.");
    }
}
