package com.example.demo.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

public record GetCountryByIdResponse(
        @Schema(example = "Россия")
        @NotNull
        String name
){

}
