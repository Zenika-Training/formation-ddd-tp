package com.zenika.ddd.course;

import com.zenika.ddd.shared.StatutCourse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class CourseEntityTest {

    @Test
    @DisplayName("Values returned by the getter should not affect the source entity")
    void values_returned_by_the_getter_should_not_affect_the_source_entity() {
        // Given
        StatutCourse statutCourse = StatutCourse.AVAILABLE;
        CourseEntity courseEntity = CourseEntity.builder()
                .id(new CourseVoId(UUID.fromString("f47ac10b-58cc-4372-a567-0e02b2c3d479")))
                .statut(statutCourse).build();


        // When
        statutCourse = StatutCourse.CANCELLED;

        // Then
        assertEquals(StatutCourse.AVAILABLE, courseEntity.getStatut());
    }

    @Test
    @DisplayName("Two entities with the same id  but of different type should not be equals")
    void two_entities_with_the_same_id_but_of_different_type_should_not_be_equals() {
        // Given
        CourseEntity courseEntity = CourseEntity.builder().id(new CourseVoId(UUID.fromString("f47ac10b-58cc-4372-a567-0e02b2c3d479"))).build();
        LivreurEntity livreurEntity = LivreurEntity.builder().id(new LivreurVoId(UUID.fromString("f47ac10b-58cc-4372-a567-0e02b2c3d479"))).build();

        // When
        boolean areEquals = courseEntity.getId().equals(livreurEntity.getId());

        // Then
        assertFalse(areEquals);
    }

}
