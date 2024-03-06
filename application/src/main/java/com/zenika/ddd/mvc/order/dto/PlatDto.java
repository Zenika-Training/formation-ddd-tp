package com.zenika.ddd.mvc.order.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class PlatDto {

    private String id;
    private String nom;
    private double prix;
    private List<byte[]> images;
}
