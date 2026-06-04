package br.com.Okena.domain.user.dto;

import br.com.Okena.domain.bairro.dto.BairroResponseDTO;
import br.com.Okena.domain.user.User;

public record DetailsUser(String nome,
                          String login,
                          BairroResponseDTO bairro) {


    public DetailsUser(User user) {
        this(
                user.getNome(),
                user.getLogin(),
                new BairroResponseDTO(user.getBairro())
        );
    }
}
