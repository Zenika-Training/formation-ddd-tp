package com.zenika.ddd.commande.stub;

import com.zenika.ddd.commande.OrderEntity;
import com.zenika.ddd.doc.Stub;
import com.zenika.ddd.port.CommandeRepository;

import java.util.List;
import java.util.Optional;

@Stub
public class CommandeEmptyRepositoryStub implements CommandeRepository {
    @Override
    public Optional<OrderEntity> save(OrderEntity OrderEntity) {
        return Optional.empty();
    }

    @Override
    public Optional<OrderEntity> findById(String id) {
        return Optional.empty();
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
