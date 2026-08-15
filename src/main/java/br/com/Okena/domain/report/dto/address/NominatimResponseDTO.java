package br.com.Okena.domain.report.dto.address;

import com.fasterxml.jackson.annotation.JsonProperty;

public record NominatimResponseDTO(
        @JsonProperty("address")
        AddressDTO address
) {}