package com.example.testdeploy;

import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Range;

public record CreatePersonDto(
    @NotNull String name,
    @NotNull @Range(min = 0, max = 150) Integer age
) {

}
