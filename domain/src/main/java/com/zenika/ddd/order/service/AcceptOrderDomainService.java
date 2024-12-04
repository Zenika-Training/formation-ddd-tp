package com.zenika.ddd.order.service;

import com.zenika.ddd.course.CourseEntity;
import com.zenika.ddd.course.DeliveryManEntity;
import com.zenika.ddd.doc.DomainService;
import com.zenika.ddd.order.OrderEntity;
import com.zenika.ddd.port.DeliveryManRepository;

import java.util.ArrayList;
import java.util.List;

@DomainService
public class AcceptOrderDomainService {

    private final List<OrderEntity> commandes = new ArrayList<>();
    private final DeliveryManRepository deliveryManRepository;

    public AcceptOrderDomainService(DeliveryManRepository deliveryManRepository) {
        this.deliveryManRepository = deliveryManRepository;
    }

    public void ajouterCommande(OrderEntity commande) {
        commandes.add(commande);
    }

    public CourseEntity selectionnerCommande(OrderEntity commande) {

        CourseEntity course = CourseEntity.builder()
                .commandeId(commande.getId())
                .build();

        return course;
    }

    public OrderEntity accept(OrderEntity order) {

        // Get a deliveryMan from the repository
        DeliveryManEntity deliveryMan = deliveryManRepository.getDeliveryMan();

        // TODO: TP-3 Change OrderEntity state to ACCEPTED

        return order;
    }
}
