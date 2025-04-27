package com.example.testdeploy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @Mock
    private PersonMapper personMapper;

    @InjectMocks
    private PersonService personService;

    /**
     * Test class for {@link PersonService#getPerson(UUID)}
     * Scenarios:
     * - Successfully retrieve a person by ID.
     * - Handle case when person is not found (throws exception).
     */

    @Test
    void shouldRetrievePersonById() {
        UUID personId = UUID.randomUUID();
        Person mockPerson = new Person(personId, "John Doe", 30);
        ReadPersonDto mockDto = new ReadPersonDto(personId, "John Doe", 30);

        when(personRepository.findById(personId)).thenReturn(Optional.of(mockPerson));
        when(personMapper.toReadPersonDto(mockPerson)).thenReturn(mockDto);

        ReadPersonDto result = personService.getPerson(personId);

        assertThat(result)
            .isNotNull()
            .extracting(ReadPersonDto::id, ReadPersonDto::name, ReadPersonDto::age)
            .containsExactly(personId, "John Doe", 30);
    }

    @Test
    void shouldThrowExceptionWhenPersonNotFound() {
        UUID personId = UUID.randomUUID();
        when(personRepository.findById(personId)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> personService.getPerson(personId))
            .isInstanceOf(RuntimeException.class);
    }
}
