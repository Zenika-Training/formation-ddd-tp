package com.zenika.ddd.mvc.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder(toBuilder = true)
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ClientFinal {
    private String id;
    private String first_name;
    private String last_name;
    private String adress;
    private Double latitude;
    private Double longitude;
    private String phone;
    private String mail;
}
