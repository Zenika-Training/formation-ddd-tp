package com.zenika.ddd.mvc.adapter;

import com.zenika.ddd.course.CourseEntity;
import com.zenika.ddd.course.Destination;
import com.zenika.ddd.course.RestaurantEntity;
import com.zenika.ddd.mvc.dto.CoursesDTO;
import com.zenika.ddd.shared.Position;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class CoursesMapper {
    public List<CourseEntity> toCourseEntities(List<CoursesDTO> coursesDTO) {
        return coursesDTO.stream().map(this::mapCourseDTOsToCourseEntities).toList();
    }

    private CourseEntity mapCourseDTOsToCourseEntities(CoursesDTO coursesDTO) {
        return CourseEntity.builder()
                .commandeId(UUID.fromString(coursesDTO.getCommandesDTOs().get(0).getId()))
                .destination(Destination.builder()
                        .latitude(coursesDTO.getCommandesDTOs().get(0).getClientFinal().getLatitude())
                        .longitude(coursesDTO.getCommandesDTOs().get(0).getClientFinal().getLongitude())
                        .build())
                .restaurant(RestaurantEntity.builder()
                        .id(UUID.fromString(coursesDTO.getCommandesDTOs().get(0).getRestaurant().getId()))
                        .position(Position.builder()
                                .latitude(coursesDTO.getCommandesDTOs().get(0).getRestaurant().getLatitude())
                                .longitude(coursesDTO.getCommandesDTOs().get(0).getRestaurant().getLongitude())
                        .build())
                .build())
                .build();
    }

}
