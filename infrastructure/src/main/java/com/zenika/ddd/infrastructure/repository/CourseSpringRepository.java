package com.zenika.ddd.infrastructure.repository;

import com.zenika.ddd.infrastructure.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseSpringRepository extends JpaRepository<CourseEntity, String> {
}
