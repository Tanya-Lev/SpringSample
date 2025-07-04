package com.example.demo.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

public record RegionResponse(
        @Schema(example = "1")
        @NotNull
        String id,

        @Schema(example = "Ростовская область")
        @NotNull
        String name,

        @Schema(example = "Россия")
        @NotNull
        String countryName
) {
}
