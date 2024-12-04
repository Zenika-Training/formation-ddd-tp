package com.zenika.ddd.course;

import com.zenika.ddd.shared.BusinessException;
import com.zenika.ddd.shared.OrderStatus;
import com.zenika.ddd.shared.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CourseEntityTest {

    @Test
    @DisplayName("Course should be created with a delivery status AVAILABLE")
    void course_should_be_created_with_a_delivery_status_accepted() {
        // Given
        CourseEntity course = CourseEntity.builder().build();

        // Then
        assertEquals(OrderStatus.AVAILABLE, course.getStatut());
    }

    @Test
    @DisplayName("Course always has a unique identifier")
    void course_always_has_a_unique_identifier() {
        // When
        CourseEntity course1 = CourseEntity.builder().build();
        CourseEntity course2 = CourseEntity.builder().build();

        // Then
        assertNotNull(course1.getId());
        assertNotNull(course2.getId());
        assertNotEquals(course1.getId(), course2.getId());
    }

    @Test
    @DisplayName("An ACCEPTED course must have a deliveryMan setted")
    void an_accepted_course_must_have_a_deliveryMan_setted() {
        // Given
        CourseEntity course = CourseEntity.builder().build();
        DeliveryManEntity deliveryMan = new DeliveryManEntity("Outan", "Laurent", new Position(47.216620, -1.577638), "laurent.outan@gmail.com");

        // When
        course.accept(deliveryMan);

        // Then
        assertEquals(deliveryMan, course.getDeliveryMan());
    }

    @Test
    @DisplayName("We should raise an exception if we try to collect a course that is not in TO_COLLECT status")
    void we_should_raise_an_exception_if_we_try_to_collect_a_course_that_is_not_in_to_collect_status() {
        // Given
        CourseEntity course = CourseEntity.builder().build();

        // Then
        assertThrows(BusinessException.class, course::collect);
    }

    @Test
    @DisplayName("If a course is in TO_COLLECT status, we should be able to collect it")
    void if_a_course_is_in_to_collect_status_we_should_be_able_to_collect_it() {
        // Given
        CourseEntity course = CourseEntity.builder().build();
        DeliveryManEntity deliveryMan = new DeliveryManEntity("Loss", "Debbie", new Position(47.216620, -1.577638), "debbie.loss@hotmail.com");

        // When
        course.accept(deliveryMan);

        // Then
        assertEquals(OrderStatus.ACCEPTED, course.getStatut());
    }
}
