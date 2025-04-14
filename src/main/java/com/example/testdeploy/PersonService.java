package com.example.testdeploy;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Log4j2
@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    public ReadPersonDto getPerson(UUID id) {
        Person person = personRepository.findById(id).orElseThrow();
        return personMapper.toReadPersonDto(person);
    }

    public ReadPersonDto createPerson(CreatePersonDto dto) {
        Person person = personMapper.toPersonEntity(dto);
        Person saved = personRepository.save(person);
        log.info("Created person: {}", saved);
        return personMapper.toReadPersonDto(saved);
    }
}
