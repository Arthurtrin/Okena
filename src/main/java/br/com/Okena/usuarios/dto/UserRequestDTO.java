package br.com.Okena.usuarios.dto;

import br.com.Okena.usuarios.entity.Bairro;
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
