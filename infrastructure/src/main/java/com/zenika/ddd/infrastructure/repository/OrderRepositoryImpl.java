package com.zenika.ddd.infrastructure.repository;

import com.zenika.ddd.infrastructure.entity.OrderJpaEntity;
import com.zenika.ddd.infrastructure.updator.OrderEntityMapper;
import com.zenika.ddd.order.model.OrderEntity;
import com.zenika.ddd.port.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryImpl implements OrderRepository {

    private final OrderRepositorySpring orderRepositorySpring;

    @Override
    public List<OrderEntity> getAll() {
        List<OrderJpaEntity> orderJpaEntityList = orderRepositorySpring.findAll();
        return orderJpaEntityList.stream().map(OrderEntityMapper::convert).toList();
    }

    @Override
    public Optional<OrderEntity> getById(String id) {
        Optional<OrderJpaEntity> orderJpaEntityOpt = orderRepositorySpring.findById(id);
        return orderJpaEntityOpt.map(OrderEntityMapper::convert);
    }

    @Override
    public OrderEntity save(OrderEntity orderEntity) {
        return OrderEntityMapper.convert(orderRepositorySpring.save(OrderEntityMapper.convert(orderEntity)));
    }
}
