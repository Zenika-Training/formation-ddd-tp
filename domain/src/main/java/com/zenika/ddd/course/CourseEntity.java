package com.zenika.ddd.course;

import com.zenika.ddd.doc.DomainObject;
import com.zenika.ddd.shared.BusinessException;
import com.zenika.ddd.shared.StatutCourse;

import java.util.UUID;

@DomainObject
public class CourseEntity {
    private UUID id; // TODO: TP2-2 Init this field properly
    private UUID commandeId;
    private DeliveryManEntity deliveryManEntity;
    private StatutCourse statut; // TODO: TP2-1 Init this field properly
    private Destination destination;
    private RestaurantEntity restaurant;

    public void accept(DeliveryManEntity deliveryMan) {
        // TODO: TP2-1 Implement this method
    }

    public void collect() throws BusinessException {
        // TODO: TP2-1 Implement this method
    }

    public StatutCourse getStatut() {
        return this.statut;
    }

    public DeliveryManEntity getDeliveryMan() {
        return this.deliveryManEntity;
    }

    public UUID getId() {
        return this.id;
    }
}
