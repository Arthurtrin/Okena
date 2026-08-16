package br.com.Okena.controller;

import br.com.Okena.domain.insight.dto.*;
import br.com.Okena.service.InsightService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/insight")
public class InsightController {

    private final InsightService service;

    public InsightController(InsightService service){
        this.service = service;
    }

    @GetMapping
    public InsigthDTO obterInsight(){
        return service.obterInsigths();
    }


    @GetMapping("/resumo")
    public ResumoDTO obterResumo(){
        return service.resumo();
    }

    @GetMapping("/report-por-categoria")
    public List<ReportPorCategoriaDTO> obterReportPorCategoria(){
        return service.reportPorCategoria();
    }

    @GetMapping("/em-alta")
    public List<EmAltaDTO> ObterEmAltaDTO(){
        return service.reportsEmAltaDTO();
    }

    @GetMapping("/evolucao-temporal")
    public List<EvolucaoTemporalDTO> ObterEvolucaoTemporal(){
        return service.evolucaoTemporal();
    }

    @GetMapping("/bairros-com-mais-reports")
    public List<BairrosComMaisOcorrenciasDTO> obterBairrosComMaisOcorrencias(){
        return service.buscarBairrosComMaisOcorrencias();
    }

    @GetMapping("/cidades-com-mais-reports")
    public List<CidadesComMaisOcorrenciasDTO> obterCidadesComMaisOcorrencias(){
        return service.buscarCidadesComMaisOcorrencias();
    }



    @GetMapping("/categorias")
    public List<String> obterCategorias(){
        return service.obterCategorias();
    }

//    @GetMapping("/informacoes")
//    public UserInfoDTO info(){
//        return service.userInfos();
//    }
}
