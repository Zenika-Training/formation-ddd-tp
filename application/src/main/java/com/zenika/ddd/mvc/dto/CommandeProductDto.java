package com.zenika.ddd.mvc.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CommandeProductDto {
    private String id;
    private String name;
    private double price;
}
