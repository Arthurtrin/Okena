package br.com.Okena.user.dto;

import br.com.Okena.user.entity.Bairro;

import java.util.List;

public record UserInfoDTO(Long qtdUsuarios,
                          Bairro bairroComMaisUsuarios,
                          Bairro bairroComMenosUSuario,
                          List<Bairro> bairrosEmUso) {

}
