package com.zenika.ddd.domain.course;

import java.util.UUID;

public class CourseEntity {
    private UUID id;
    private CoursierEntity coursier;
    private StatutCourse statut;
    private Destnation destination;
    private RestaurantEntity restaurant;
}
