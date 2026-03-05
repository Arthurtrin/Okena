package br.com.Okena.usuarios.dto;

import br.com.Okena.usuarios.entity.Bairro;

import java.util.List;

public record UserDTO(Long qtdUsuarios,
                      Bairro bairroComMaisUsuarios,
                      Bairro bairroComMenosUSuario,
                      List<Bairro> bairrosEmUso) {

}
