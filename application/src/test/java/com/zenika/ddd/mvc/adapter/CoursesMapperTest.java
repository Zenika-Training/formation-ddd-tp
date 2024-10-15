package com.zenika.ddd.mvc.adapter;

import com.zenika.ddd.course.CourseEntity;
import com.zenika.ddd.course.Destination;
import com.zenika.ddd.course.RestaurantEntity;
import com.zenika.ddd.mvc.dto.ClientFinal;
import com.zenika.ddd.mvc.dto.CommandeDTO;
import com.zenika.ddd.mvc.dto.CoursesDTO;
import com.zenika.ddd.mvc.dto.Restaurant;
import com.zenika.ddd.shared.Position;
import com.zenika.ddd.shared.StatutCourse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CoursesMapperTest {

    private final CoursesMapper coursesMapper = new CoursesMapper();

    @Test
    @DisplayName("Should map a list of CoursesDTO to a list of CourseEntity")
    void should_map_a_list_of_coursesDTO_to_a_list_of_courseEntity() {
        // Given
        ClientFinal clientFinal = ClientFinal.builder()
                .id("f47ac10b-58cc-FFFF-a567-0e02b2c3d481")
                .first_name("John")
                .last_name("Doe")
                .latitude(48.8566)
                .longitude(2.3522)
                .build();
        CoursesDTO coursesDTO = CoursesDTO.builder()
                .commandesDTOs(List.of(CommandeDTO.builder()
                        .id("f47ac10b-58cc-4372-a567-0e02b2c3d479")
                        .dateCommande(LocalDateTime.of(2024, 10, 15, 10, 15))
                        .clientFinal(clientFinal)
                        .restaurant(Restaurant.builder()
                                .id("f47ac10b-58cc-4372-a567-0e02b2c3d480")
                                .nom("KFC")
                                .latitude(48.8577)
                                .longitude(2.3511)
                                .build())
                        .build()))
                .build();
        Destination expectedDestination = Destination.builder()
                .latitude(48.8566)
                .longitude(2.3522)
                .build();

        // When
        List<CourseEntity> result = coursesMapper.toCourseEntities(List.of(coursesDTO));

        // Then
        assertThat(result.get(0)).extracting(
                        "commandeId",
                        "statut",
                        "destination",
                        "restaurant")
                .containsExactly(
                        UUID.fromString("f47ac10b-58cc-4372-a567-0e02b2c3d479"),
                        StatutCourse.AVAILABLE,
                        expectedDestination,
                        RestaurantEntity.builder()
                                .id(UUID.fromString("f47ac10b-58cc-4372-a567-0e02b2c3d480"))
                                .position(Position.builder()
                                        .latitude(48.8577)
                                        .longitude(2.3511)
                                        .build())
                                .build()
                );
        assertThat(result.get(0).getDestination()).isEqualTo(expectedDestination);
    }
}
