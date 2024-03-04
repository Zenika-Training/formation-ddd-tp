package com.zenika.ddd.commande;

import com.zenika.ddd.course.CourseEntity;
import com.zenika.ddd.doc.DomainService;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@DomainService
@NoArgsConstructor
public class SelectionnerCommandeDomainService {

    private final List<OrderEntity> commandes = new ArrayList<>();

    public void ajouterCommande(OrderEntity commande) {
        commandes.add(commande);
    }

    public CourseEntity selectionnerCommande(OrderEntity commande) {

        CourseEntity course = CourseEntity.builder()
                .commandeId(commande.getId())
                .build();

        return course;
    }
}
