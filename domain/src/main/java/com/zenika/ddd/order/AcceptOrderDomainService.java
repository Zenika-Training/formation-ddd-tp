package com.zenika.ddd.order;

import com.zenika.ddd.course.CourseEntity;
import com.zenika.ddd.doc.DomainService;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@DomainService
@RequiredArgsConstructor
public class AcceptOrderDomainService {

    private final List<OrderEntity> commandes = new ArrayList<>();
    private final DeliveryManRepository deliveryManRepository;

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

        // Change OrderEntity state to ACCEPTED
        order.accept();

        // Add a deliveryMan on the Order
        DeliveryManEntity deliveryMan = deliveryManRepository.getDeliveryMan();
        order.affectDeliveryMan(deliveryMan);

        return order;
    }
}
