package com.zenika.ddd.order;

import com.zenika.ddd.doc.Stub;
import com.zenika.ddd.port.OrderRepository;

import java.util.List;
import java.util.UUID;

@Stub
public class OrderRepositoryStub implements OrderRepository {

    @Override
    public List<OrderEntity> getAll() {
        return List.of(OrderEntity.builder()
                .id(UUID.fromString("afd0e3b4-0b3b-0000-8b3b-0b3b4b3b0b3b"))
                .status(Status.AVAILABLE)
                .build(),
                OrderEntity.builder()
                        .id(UUID.fromString("afd0e3b4-0b3b-0011-8b3b-0b3b4b3b0b3b"))
                        .status(Status.AVAILABLE)
                        .build(),
                OrderEntity.builder()
                        .id(UUID.fromString("afd0e3b4-0b3b-0022-8b3b-0b3b4b3b0b3b"))
                        .status(Status.AVAILABLE)
                        .build()
        );
    }


}
