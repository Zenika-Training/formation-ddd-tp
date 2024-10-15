package com.zenika.ddd.mvc.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder(toBuilder = true)
@Getter
public class CoursesDTO {
    List<CommandeDTO> commandesDTOs;
}
