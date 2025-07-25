package com.example.demo.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

public record CreateRegionRequest(
        @Schema(example = "Ростовская область")
        @NotNull
        String name,

        @Schema(example = "1")
        @NotNull
        String countryId

) {
}
