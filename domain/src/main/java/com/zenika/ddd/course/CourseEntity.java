package com.zenika.ddd.course;

import com.zenika.ddd.doc.DomainObject;
import com.zenika.ddd.shared.StatutCourse;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Builder
@Getter
@DomainObject
public class CourseEntity {
    @Builder.Default
    private final UUID id = UUID.randomUUID();
    private UUID commandeId;
    private CoursierEntity coursier;
    @Builder.Default
    private StatutCourse statut = StatutCourse.ACCEPTED;
    private Destination destination;
    private RestaurantEntity restaurant;
}
