package br.com.Okena.service;

import br.com.Okena.domain.report.dto.address.NominatimResponseDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class GeocodingService {

    private final RestClient restClient;

    public GeocodingService(RestClient restClient) {
        this.restClient = restClient;
    }

    public NominatimResponseDTO buscarEndereco(Double latitude, Double longitude) {
        return restClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .scheme("https")
                        .host("nominatim.openstreetmap.org")
                        .path("/reverse")
                        .queryParam("lat", latitude)
                        .queryParam("lon", longitude)
                        .queryParam("format", "jsonv2")
                        .build()
                )
                .retrieve()
                .body(NominatimResponseDTO.class);
    }
}
