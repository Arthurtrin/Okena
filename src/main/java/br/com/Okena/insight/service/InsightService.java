package br.com.Okena.insight.service;

import br.com.Okena.report.dto.ReportRespondeDTO;
import br.com.Okena.report.entity.Categoria;
import br.com.Okena.report.repository.ReportRepository;
import br.com.Okena.user.dto.UserInfoDTO;
import br.com.Okena.user.entity.Bairro;
import br.com.Okena.user.repository.UserRepository;
import br.com.Okena.user.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class InsightService {

    private final UserRepository userRepository;

    // Injeção de dependencias
    public InsightService(ReportRepository reportRepository, UserService userService, UserRepository userRepository){
        this.userRepository = userRepository;
    }

    /* ESTATISTICAS */
    // Pega os valores de bairro
    public List<String> obterBairros() {
        return Stream.of(Bairro.values()).map(Bairro::getBairro).toList();
    }

    public List<String> obterCategorias() {
        return Stream.of(Categoria.values()).map(Categoria::getCategoria).toList();
    }

    public UserInfoDTO userInfos() {
        return toDTO(userRepository.count(),
                userRepository.bairroComMaisUsuario(),
                userRepository.bairroComMenosUsuario(),
                userRepository.bairrosEmUso());
    }

    private UserInfoDTO toDTO(long qtdUsuarios,
                              Bairro bairroMaisUsuario,
                              Bairro bairroMenosUsuario,
                              List<Bairro> bairrosEmUso) {

        return new UserInfoDTO(qtdUsuarios,
                bairroMaisUsuario,
                bairroMenosUsuario, bairrosEmUso);
    }
}
