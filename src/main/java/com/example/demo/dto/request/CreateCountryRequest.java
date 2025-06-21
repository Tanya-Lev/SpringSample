package com.example.demo.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.NotNull;

public record CreateCountryRequest(
        @Schema(example = "Россия")
        @NotNull
        String name
) {

}
