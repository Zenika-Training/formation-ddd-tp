package com.zenika.ddd.infrastructure.repository;

import com.zenika.ddd.infrastructure.entity.OrderJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepositorySpring extends JpaRepository<OrderJpaEntity, String> {

}
