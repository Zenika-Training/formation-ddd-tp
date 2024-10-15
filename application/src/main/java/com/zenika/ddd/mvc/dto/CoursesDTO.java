package com.zenika.ddd.mvc.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CoursesDTO {
    List<CommandeDTO> commandesDTOs;
}
