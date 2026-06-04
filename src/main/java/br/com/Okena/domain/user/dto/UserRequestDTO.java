package br.com.Okena.domain.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserRequestDTO(
        @NotNull(message = "{bairro.obrigatorio}")
        Long bairroId,

        @NotBlank
        String cpf,

        @NotBlank
        @Email
        String email,

        @NotBlank
        String nome,

        @NotBlank
        String login,

        @NotBlank
        String senha) {
}
