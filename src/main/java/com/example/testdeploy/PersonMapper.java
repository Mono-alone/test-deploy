package com.example.testdeploy;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PersonMapper {

    ReadPersonDto toReadPersonDto(Person person);

    @Mapping(target = "id", ignore = true)
    Person toPersonEntity(CreatePersonDto dto);
}
