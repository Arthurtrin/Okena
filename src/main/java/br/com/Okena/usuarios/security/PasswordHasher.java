package br.com.Okena.usuarios.security;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordHasher {

    private PasswordHasher() {
        // impede instanciação
    }

    public static String hash(String senha) {
        return BCrypt.hashpw(senha, BCrypt.gensalt());
    }

    public static boolean matches(String senhaPura, String senhaHash) {
        return BCrypt.checkpw(senhaPura, senhaHash);
    }
}