package com.example.demo.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

public record ReadCountryResponse (
        @Schema(example = "1")
        @NotNull
        String id,
        @Schema(example = "Russia")
        @NotNull
        String name
){

}
