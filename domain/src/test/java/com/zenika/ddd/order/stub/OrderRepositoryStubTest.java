package com.zenika.ddd.order.stub;

import com.zenika.ddd.order.OrderEntity;
import com.zenika.ddd.port.OrderRepository;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderRepositoryStubTest {

    OrderRepository orderRepositoryStub = new OrderRepositoryStub();

    @Test
    void should_find_an_existing_order() {
        // When
        Optional<OrderEntity> orderEntity = orderRepositoryStub.getById("afd0e3b4-0b3b-4b3b-8b3b-0b3b4b3b0b3b");

        // then
        assertEquals(Optional.empty(), orderEntity);
    }


    @Test
    void should_get_an_Optional_empty_if_the_id_doesn_t_exists() {

        // when
        Optional<OrderEntity> optionalOrderEntity = orderRepositoryStub.getById("afd0e3b4-0b3b-0000-8b3b-0b3b4b3b0b3b");

        // then
        assertThat(optionalOrderEntity).isPresent();
        OrderEntity orderEntity = optionalOrderEntity.get();
        assertEquals(UUID.fromString("afd0e3b4-0b3b-0000-8b3b-0b3b4b3b0b3b"), orderEntity.getId());
    }
}
