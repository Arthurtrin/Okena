package br.com.Okena.domain.insight.dto;

import java.util.List;

public record InsigthDTO(
        ResumoDTO resumoDTO,
        List<ReportPorCategoriaDTO> reportPorCategoriaDTO,
        List<EvolucaoTemporalDTO> evolucaoTemporal,
        List<EmAltaDTO> emAltaDTO,
        List<CidadesComMaisOcorrenciasDTO> cidadesComMaisOcorrencias,
        List<BairrosComMaisOcorrenciasDTO> bairrosComMaisOcorrenciasDTOS
) {
}
