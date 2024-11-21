package com.zenika.ddd.mvc.adapter;

import com.zenika.ddd.mvc.dto.CommandeMessageDto;
import com.zenika.ddd.mvc.dto.CommandeProductDto;
import com.zenika.ddd.order.OrderEntity;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CommandeMapperTest {

    private final CommandeMapper commandeMapper = new CommandeMapper();

    @Test
    void should_map_commande_message_dto_to_commande() {
        // Given
        CommandeMessageDto commandeMessageDto = CommandeMessageDto.builder()
                .id("1")
                .date("2023-06-01")
                .products(List.of(
                        CommandeProductDto.builder()
                                .id("1")
                                .name("Product 1")
                                .price(100.0)
                                .build()
                ))
                .build();

        // When
        OrderEntity order = commandeMapper.mapCommandeMessageDtoToCommandeEntity(commandeMessageDto);

        // Then
        assertNotNull(order.getId());
    }
}
