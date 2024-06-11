package com.zenika.ddd.service;

import com.zenika.ddd.commande.SelectionnerCommandeDomainService;
import com.zenika.ddd.commande.stub.CommandeEmptyRepositoryStub;
import com.zenika.ddd.mvc.adapter.CommandeMapper;
import com.zenika.ddd.mvc.adapter.ProduitMapper;
import com.zenika.ddd.mvc.dto.OrderDto;
import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertThrows;

class CreateOrderApplicationServiceTest {

    private CreateOrderApplicationService createOrderApplicationService;

    @BeforeEach
    void setUp() {
        createOrderApplicationService = new CreateOrderApplicationService(new CommandeMapper(new ProduitMapper()), new SelectionnerCommandeDomainService(new CommandeEmptyRepositoryStub()));
    }

    @Test
    @Description("Should raise an exception if product list is empty")
    void should_raise_an_exception_if_product_list_iempty() {
        // Given
        OrderDto orderDto = OrderDto.builder()
                .dateCreation(LocalDateTime.of(2024, 6, 11, 11, 0))
                .id(UUID.fromString("f47ac10b-58cc-4372-a567-0e02b2c3d479").toString())
                .clientId(UUID.fromString("f47ac10b-58cc-4372-a567-0e02b2c3d479").toString())
                .produits(List.of())
                .build();

        // When / Then
        assertThrows(IllegalArgumentException.class, () -> {
            createOrderApplicationService.createOrder(orderDto);
        });
    }

}
