package com.zenika.ddd.infrastructure.repository;

import com.zenika.ddd.course.CourseEntity;
import com.zenika.ddd.course.LivreurEntity;
import com.zenika.ddd.infrastructure.adapter.CourseDomainEntitytoJpaEntityMapper;
import com.zenika.ddd.port.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@RequiredArgsConstructor
@Primary
public class CourseRepositoryInfrastructureService implements CourseRepository {

    private final CourseSpringRepository courseSpringRepository;
    private final CourseDomainEntitytoJpaEntityMapper courseDomainEntitytoJpaEntityMapper;

    @Override
    public void save(CourseEntity courseEntity) {
        courseSpringRepository.save(courseDomainEntitytoJpaEntityMapper.mapCourseDomainEntitytoCourseJpaEntity(courseEntity));
    }

    @Override
    public LivreurEntity currentLivreur() {
        return LivreurEntity.builder().id(UUID.fromString("f47b3b2d-4f3b-0000-0000-4b3f4b3f4b3f")).nom("Outan").prenom("Laurent").email("laurent.outan@gmail.com").adresse(null).build();
    }
}
