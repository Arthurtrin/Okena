package br.com.Okena.domain.insight.dto;

public record ResumoDTO(
        Long totalReports,
        Long reportsUltimosSeteDias,
        Long reportsUltimas24h,
        Double variacao
) {
}
