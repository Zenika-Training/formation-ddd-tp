package com.zenika.ddd.commande.stub;

import com.zenika.ddd.commande.OrderEntity;
import com.zenika.ddd.port.CommandeRepository;

import java.util.List;
import java.util.Optional;

public class CommandeExistingOrderRepositoryStub implements CommandeRepository {
    @Override
    public Optional<OrderEntity> save(OrderEntity orderEntity) {
        return Optional.of(orderEntity);
    }

    @Override
    public Optional<OrderEntity> findById(String id) {
        return Optional.of(OrderEntity.builder().build());
    }

    @Override
    public List<OrderEntity> findByClientId(String clientId) {
        return List.of();
    }

    @Override
    public List<OrderEntity> findAll() {
        return List.of();
    }

    @Override
    public void deleteById(String id) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void update(OrderEntity OrderEntity) {

    }
}
