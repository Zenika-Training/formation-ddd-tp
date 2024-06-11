package com.zenika.ddd.port;

import com.zenika.ddd.commande.OrderEntity;
import com.zenika.ddd.doc.DomainService;

import java.util.List;
import java.util.Optional;

@DomainService
public interface CommandeRepository {

    List<OrderEntity> save(List<OrderEntity> OrderEntity);

    Optional<OrderEntity> findById(String id);

    List<OrderEntity> findByClientId(String clientId);

    List<OrderEntity> findAll();

    void deleteById(String id);

    void deleteAll();

    void update(OrderEntity OrderEntity);

}
