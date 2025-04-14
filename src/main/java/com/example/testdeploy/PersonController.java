package com.example.testdeploy;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @GetMapping("/{id}")
    public ReadPersonDto getPerson(@NotNull @PathVariable("id") UUID id) {
        return personService.getPerson(id);
    }

    @PostMapping
    public ReadPersonDto createPerson(@Valid @RequestBody CreatePersonDto dto) {
        return personService.createPerson(dto);
    }
}
