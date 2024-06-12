package com.zenika.ddd.infrastructure.repository;

import com.zenika.ddd.commande.OrderEntity;
import com.zenika.ddd.port.CommandeRepository;
import com.zenika.ddd.infrastructure.adapter.OrderMapper;
import com.zenika.ddd.infrastructure.entity.OrderJpaEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CommandeRepositoryImpl implements CommandeRepository {

    private final OrderMapper orderMapper;
    private final CommandeSpringRepository commandeSpringRepository;

    @Override
    public Optional<OrderEntity> save(OrderEntity OrderEntity) {

        OrderJpaEntity orderJpaEntity = orderMapper.mapOrderEntityToOrderJpaEntity(OrderEntity);

        OrderJpaEntity orderJpaSavedEntity = commandeSpringRepository.save(orderJpaEntity);

        return Optional.of(orderMapper.mapOrderJpaEntityToOrderEntity(orderJpaSavedEntity));
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
