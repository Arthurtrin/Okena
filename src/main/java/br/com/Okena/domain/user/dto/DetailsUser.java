package br.com.Okena.domain.user.dto;

import br.com.Okena.domain.user.User;

public record DetailsUser(
        String nome,
        String login
       ) {


    public DetailsUser(User user) {
        this(
                user.getNome(),
                user.getLogin()
        );
    }
}
