package com.zenika.ddd.course;

import com.zenika.ddd.doc.DomainObject;
import com.zenika.ddd.shared.StatutCourse;

import java.util.UUID;

@DomainObject
public class CourseEntity {
    private final UUID id = UUID.randomUUID();
    private UUID commandeId;
    private DeliveryManEntity deliveryManEntity;
    private StatutCourse statut = StatutCourse.ACCEPTED;
    private Destination destination;
    private RestaurantEntity restaurant;
}
