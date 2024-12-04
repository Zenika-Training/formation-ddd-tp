package com.zenika.ddd.order;

import com.zenika.ddd.course.CourseEntity;
import com.zenika.ddd.doc.DomainService;


import java.util.ArrayList;
import java.util.List;


@DomainService
public class SelectionnerCommandeDomainService {

    private final List<OrderEntity> commandes = new ArrayList<>();

    public void ajouterCommande(OrderEntity commande) {
        commandes.add(commande);
    }

    public CourseEntity selectionnerCommande(OrderEntity commande) {

        // TODO: TP3-1 Implement this method

        return null;
    }
}
