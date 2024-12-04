package com.zenika.ddd.order.stub;

import com.zenika.ddd.doc.Stub;
import com.zenika.ddd.order.OrderEntity;
import com.zenika.ddd.port.OrderRepository;

import java.util.List;
import java.util.Optional;

@Stub
public class OrderRepositoryStub implements OrderRepository {

    @Override
    public List<OrderEntity> getAll() {

        // TODO: TP3 - Return a list of OrderEntity

        return null;
    }

    @Override
    public Optional<OrderEntity> getById(String id) {
        List<String> idsInDB = List.of("afd0e3b4-0b3b-0000-8b3b-0b3b4b3b0b3b", "afd0e3b4-0b3b-0011-8b3b-0b3b4b3b0b3b", "afd0e3b4-0b3b-0022-8b3b-0b3b4b3b0b3b");

        // TODO: TP3 - Return an Optional of OrderEntity that is present if the id is in the list of idsInDB

        return Optional.empty();
    }

    @Override
    public OrderEntity save(OrderEntity orderEntity) {

        // TODO: TP3 - Return the saved orderEntity

        return null;
    }

}
