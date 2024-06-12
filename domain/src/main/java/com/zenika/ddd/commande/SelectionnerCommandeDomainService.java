package com.zenika.ddd.commande;

import com.zenika.ddd.course.CourseEntity;
import com.zenika.ddd.doc.DomainService;
import com.zenika.ddd.port.CommandeRepository;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Builder
@Getter
@DomainService
@RequiredArgsConstructor
public class SelectionnerCommandeDomainService {

    private final List<OrderEntity> commandes = new ArrayList<>();
    private final CommandeRepository commandeRepository;

    public OrderEntity ajouterCommande(OrderEntity commande) {

        // Guard empty product list
        if (commande.getItemVOList().isEmpty()) {
            throw new IllegalArgumentException("La commande doit contenir au moins un produit");
        }

        // Guard if the command already exists
        if (commandeRepository.findById(commande.getId().toString()).isPresent()) {
            throw new IllegalArgumentException("La commande existe déjà");
        }

        commandeRepository.save(commande);
        commandes.add(commande);
        return commande;
    }

    public CourseEntity selectionnerCommande(OrderEntity commande) {

        CourseEntity course = CourseEntity.builder()
                .commandeId(UUID.fromString(commande.getId()))
                .build();

        return course;
    }
}
