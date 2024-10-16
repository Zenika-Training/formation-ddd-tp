package com.zenika.ddd.course.service;

import com.zenika.ddd.course.CourseEntity;
import com.zenika.ddd.course.Destination;
import com.zenika.ddd.course.LivreurEntity;
import com.zenika.ddd.shared.Position;
import com.zenika.ddd.shared.StatutCourse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SelectionnerCourseDomainServiceTest {

    SelectionnerCourseDomainService selectionnerCourseDomainService = new SelectionnerCourseDomainService();

    @Test
    @DisplayName("Should assign the delivery person to the closest course")
    void should_assign_the_delivery_person_to_the_closest_course() {
        // Given
        List<CourseEntity> courses = List.of(
                CourseEntity.builder()
                        .destination(Destination.builder()
                                .latitude(47.216620)
                                .longitude(-1.577638)
                                .build())
                        .build(),
                CourseEntity.builder()
                        .destination(Destination.builder()
                                .latitude(47.271912)
                                .longitude(-1.501013)
                                .build())
                        .build()
        );
        LivreurEntity livreurEntity = LivreurEntity.builder()
                .position(Position.builder()
                        .latitude(47.216625)
                        .longitude(-1.577628)
                        .build())
                .build();

        // When
        CourseEntity result = selectionnerCourseDomainService.selectCourse(courses, livreurEntity);

        // Then
        assertNotNull(result);
        assertThat(result.getDestination()).extracting(
                Destination::latitude,
                Destination::longitude)
                .containsExactly(47.216620, -1.577638);
        assertEquals(result.getStatut(), StatutCourse.ACCEPTED);
    }

    @Test
    @DisplayName("Should return a course with status ACCEPTED")
    void should_return_a_course_with_status_accepted() {
        // Given
        List<CourseEntity> courses = List.of(CourseEntity.builder().destination(Destination.builder().build()).build());
        LivreurEntity livreurEntity = LivreurEntity.builder().position(Position.builder().build()).build();

        // When
        CourseEntity result = selectionnerCourseDomainService.selectCourse(courses, livreurEntity);

        // Then`
        assertNotNull(result);
        assertEquals(StatutCourse.ACCEPTED, result.getStatut());
    }
}
