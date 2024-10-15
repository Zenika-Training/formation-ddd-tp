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
                .id(UUID.fromString("f47ac10b-58cc-4372-a567-0e02b2c3d479"))
                .statut(statutCourse).build();


        // When
        statutCourse = StatutCourse.CANCELLED;

        // Then
        assertEquals(StatutCourse.AVAILABLE, courseEntity.getStatut());
    }
}
