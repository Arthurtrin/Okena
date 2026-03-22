package br.com.Okena.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserRequestDTO(
        @NotNull
        String bairro,

        @NotBlank
        String cpf,

        @NotBlank
        @Email
        String email,

        @NotBlank
        String nome,

        @NotBlank
        String nomeDeUsuario,

        @NotBlank
        String senha) {
}
