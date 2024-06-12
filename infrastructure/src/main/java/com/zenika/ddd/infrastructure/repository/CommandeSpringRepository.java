package com.zenika.ddd.infrastructure.repository;

import com.zenika.ddd.infrastructure.entity.OrderJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeSpringRepository extends JpaRepository<OrderJpaEntity, String> {
}
