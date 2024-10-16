package com.zenika.ddd.infrastructure.adapter;

import com.zenika.ddd.infrastructure.entity.CourseEntity;
import com.zenika.ddd.infrastructure.entity.LivreurEntity;
import org.springframework.stereotype.Component;

@Component
public class CourseDomainEntitytoJpaEntityMapper {

    public CourseEntity mapCourseDomainEntitytoCourseJpaEntity(com.zenika.ddd.course.CourseEntity courseEntity) {
        return CourseEntity.builder()
                .id(courseEntity.getId().toString())
                .commandeId(courseEntity.getCommandeId().toString())
                .livreur(LivreurEntity.builder()
                        .id(courseEntity.getLivreurEntity().getId().toString())
                        .build())
                .statutCourse(courseEntity.getStatut())
                .build();
    }
}
