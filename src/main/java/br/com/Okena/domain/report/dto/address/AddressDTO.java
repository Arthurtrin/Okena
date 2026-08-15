package br.com.Okena.domain.report.dto.address;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AddressDTO(
        @JsonProperty("state")
        String estado,

        @JsonProperty("city")
        String cidade,

        @JsonProperty("suburb")
        String bairro,

        @JsonProperty("road")
        String logradouro
) {}