package com.zenika.ddd.mvc.dto;

import lombok.Builder;
import lombok.Getter;

@Builder(toBuilder = true)
@Getter
public class Restaurant {
    String id;
    String nom;
    Double latitude;
    Double longitude;
}
