package com.example.testdeploy;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PersonMapper {

    ReadPersonDto toReadPersonDto(Person person);

    Person toPersonEntity(CreatePersonDto dto);
}
