package com.zenika.ddd.mvc.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Builder(toBuilder = true)
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BonDeCommandeDTO {
    String id;
    CommandeDTO commandeDTO;
}
