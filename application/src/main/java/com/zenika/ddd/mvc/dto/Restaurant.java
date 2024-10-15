package com.zenika.ddd.mvc.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder(toBuilder = true)
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {
    String id;
    String nom;
    Double latitude;
    Double longitude;
}
