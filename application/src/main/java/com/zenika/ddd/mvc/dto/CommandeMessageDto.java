package com.zenika.ddd.mvc.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder(toBuilder = true)
public class CommandeMessageDto {

    private String id;
    private String date;
    private List<CommandeProductDto> products;
    private ClientDto clientDto;
}
