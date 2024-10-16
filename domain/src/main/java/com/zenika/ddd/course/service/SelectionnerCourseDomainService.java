package com.zenika.ddd.course.service;

import com.zenika.ddd.course.CourseEntity;
import com.zenika.ddd.course.LivreurEntity;
import com.zenika.ddd.doc.DomainService;

import java.util.List;
import java.util.Optional;

@DomainService
public class SelectionnerCourseDomainService {

    public CourseEntity selectCourse(List<CourseEntity> courses, LivreurEntity livreurEntity) {

        if (courses.isEmpty()) {
            throw new RuntimeException("No course available");
        }

        Optional<CourseEntity> min = courses.stream().min((course1, course2) -> {
            double distance1 = course1.getDestination().toPosition().distance(livreurEntity.getPosition());
            double distance2 = course2.getDestination().toPosition().distance(livreurEntity.getPosition());
            return Double.compare(distance1, distance2);
        });
        

        // Assign the delivery person to the closest course
        CourseEntity course = min.get();
        course.assignLivreur(livreurEntity);

        return course;
    }
}
