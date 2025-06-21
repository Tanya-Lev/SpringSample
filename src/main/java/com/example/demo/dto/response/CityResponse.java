package com.example.demo.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

public record CityResponse(
        @Schema(example = "1")
        @NotNull
        String id,

        @Schema(example = "Макеевка")
        @NotNull
        String name,

        @Schema(example = "Ростовская область")
        @NotNull
        String regionName,

        @Schema(example = "Россия")
        @NotNull
        String countryName
) {
}
