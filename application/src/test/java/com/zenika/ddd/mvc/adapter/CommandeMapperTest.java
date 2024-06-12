package com.zenika.ddd.mvc.adapter;

import com.zenika.ddd.commande.OrderEntity;
import com.zenika.ddd.mvc.dto.OrderDto;
import jdk.jfr.Description;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CommandeMapperTest {

    @Test
    @Description("Should map OrderDto to our domain object OrderEntity")
    void should_map_OrderDto_to_OrderEntity() {
        // Given
        OrderDto orderDto = OrderDto.builder()
                .dateCreation(LocalDateTime.of(2024, 6, 11, 11, 0))
                .id("f47ac10b-58cc-4372-a567-0e02b2c3d479")
                .clientId("f47ac10b-58cc-4372-a567-0e02b2c3d479")
                .produits(List.of())
                .build();
        CommandeMapper commandeMapper = new CommandeMapper(new ProduitMapper());

        // When
        OrderEntity commandeEntity = commandeMapper.toCommandeEntity(orderDto);

        assertThat(commandeEntity.getId()).isEqualTo(UUID.fromString(orderDto.getId()));
    }

    @Test
    void should_map_OrderEntity_to_OrderDto() {
        // Given
        OrderEntity orderEntity = OrderEntity.builder()
                .id(UUID.fromString("f47ac10b-58cc-4372-a567-0e02b2c3d479").toString())
                .dateCommande(LocalDateTime.of(2024, 6, 11, 11, 0))
                .itemVOList(List.of())
                .build();

        // When
        OrderDto orderDto = new CommandeMapper(new ProduitMapper()).toOrderDto(orderEntity);
        assertThat(orderDto.getId()).isEqualTo("f47ac10b-58cc-4372-a567-0e02b2c3d479");
    }
}
