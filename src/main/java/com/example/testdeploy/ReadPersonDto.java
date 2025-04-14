package com.example.testdeploy;

import java.util.UUID;

public record ReadPersonDto(
    UUID id,
    String name,
    int age
) {

}
