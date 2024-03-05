package com.brett.catalog.infrastructure.catalog;

import com.brett.catalog.application.CreateModelCommand;
import org.springframework.stereotype.Component;

@Component
public class AddModeleMapper {

    public CreateModelCommand fromDto(CreateModelDto createModelDto) {
        return new CreateModelCommand(createModelDto.modele());
    }

}
