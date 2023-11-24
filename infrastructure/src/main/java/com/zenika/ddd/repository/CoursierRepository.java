package com.zenika.ddd.repository;

import com.zenika.ddd.entity.CoursierEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursierRepository extends JpaRepository<CoursierEntity, Long> {
}
