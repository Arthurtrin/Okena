package br.com.Okena.domain.user.dto;

import br.com.Okena.domain.user.Bairro;

import java.util.List;

public record UserInfoDTO(Long qtdUsuarios,
                          Bairro bairroComMaisUsuarios,
                          Bairro bairroComMenosUSuario,
                          List<Bairro> bairrosEmUso) {

}
