package com.zenika.ddd.mvc.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ClientDto {

    String clientUUID;
    String clientName;
    String clientPrenom;
    String clientAdresse;
    String clientPosition;
}
