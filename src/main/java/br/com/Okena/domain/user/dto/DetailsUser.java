package br.com.Okena.domain.user.dto;

import br.com.Okena.domain.user.User;

public record DetailsUser(
        Long id,
        String nome,
        String login
       ) {


    public DetailsUser(User user) {
        this(
                user.getId(),
                user.getNome(),
                user.getLogin()
        );
    }
}
