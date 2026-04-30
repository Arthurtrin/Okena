package br.com.Okena.infra.error.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(Long id){
        super("Usuário de id " + id + " não econtrado.");
    }
}
