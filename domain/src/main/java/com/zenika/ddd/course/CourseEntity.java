package com.zenika.ddd.course;

import com.zenika.ddd.doc.DomainObject;
import com.zenika.ddd.shared.BusinessException;
import com.zenika.ddd.shared.OrderStatus;

import java.util.UUID;

@DomainObject
public class CourseEntity {
    private UUID id; // TODO: TP2-2 Init this field properly
    private UUID commandeId;
    private DeliveryManEntity deliveryManEntity;
    private OrderStatus statut; // TODO: TP2-1 Init this field properly
    private Destination destination;
    private RestaurantEntity restaurant;

    public CourseEntity(UUID id, UUID commandeId, DeliveryManEntity deliveryManEntity, OrderStatus statut, Destination destination, RestaurantEntity restaurant) {
        this.id = id;
        this.commandeId = commandeId;
        this.deliveryManEntity = deliveryManEntity;
        this.statut = statut;
        this.destination = destination;
        this.restaurant = restaurant;
    }

    public void accept(DeliveryManEntity deliveryMan) {
        // TODO: TP2-1 Implement this method
    }

    public void collect() throws BusinessException {
        // TODO: TP2-1 Implement this method
    }

    public static CourseEntityBuilder builder() {
        return new CourseEntityBuilder();
    }

    public static class CourseEntityBuilder {
        private UUID id;
        private UUID commandeId;
        private DeliveryManEntity deliveryManEntity;
        private OrderStatus statut;
        private Destination destination;
        private RestaurantEntity restaurant;

        public CourseEntityBuilder id(UUID id) {
            this.id = id;
            return this;
        }

        public CourseEntityBuilder commandeId(UUID commandeId) {
            this.commandeId = commandeId;
            return this;
        }

        public CourseEntityBuilder deliveryManEntity(DeliveryManEntity deliveryManEntity) {
            this.deliveryManEntity = deliveryManEntity;
            return this;
        }

        public CourseEntityBuilder statut(OrderStatus statut) {
            this.statut = statut;
            return this;
        }

        public CourseEntityBuilder destination(Destination destination) {
            this.destination = destination;
            return this;
        }

        public CourseEntityBuilder restaurant(RestaurantEntity restaurant) {
            this.restaurant = restaurant;
            return this;
        }

        public CourseEntity build() {
            return new CourseEntity(id, commandeId, deliveryManEntity, statut, destination, restaurant);
        }
    }


    public OrderStatus getStatut() {
        return this.statut;
    }

    public DeliveryManEntity getDeliveryMan() {
        return this.deliveryManEntity;
    }

    public UUID getId() {
        return this.id;
    }
}
