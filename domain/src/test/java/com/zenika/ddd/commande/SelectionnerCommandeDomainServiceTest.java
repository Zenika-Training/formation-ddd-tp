package com.zenika.ddd.commande;

import com.zenika.ddd.course.CourseEntity;
import com.zenika.ddd.shared.StatutCourse;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SelectionnerCommandeDomainServiceTest {

    private final SelectionnerCommandeDomainService selectionnerCommandeDomainService = new SelectionnerCommandeDomainService();

    @Test
    @DisplayName("Doit recevoir une commande")
    void should_recevoir_commande() {
        // Given
        var commande = CommandeEntity.builder().id(UUID.randomUUID()).build();

        // When
        selectionnerCommandeDomainService.ajouterCommande(commande);

        // Then
        Assertions.assertThat(selectionnerCommandeDomainService.getCommandes()).hasSize(1);
        Assertions.assertThat(selectionnerCommandeDomainService.getCommandes().get(0).getId()).isEqualTo(commande.getId());
    }


    @Test
    @DisplayName("Doit accepter une commande et en faire une course")
    void should_accept_a_command_to_make_a_course() {
        // Given
        var commande1 = CommandeEntity.builder().id(UUID.randomUUID()).build();
        var commande2 = CommandeEntity.builder().id(UUID.randomUUID()).build();

        // When
        CourseEntity course = selectionnerCommandeDomainService.selectionnerCommande(commande2);

        // Then
        assertEquals(course.getCommandeId(), commande2.getId());
    }

    @Test
    @DisplayName("Une commande acceptée doit être transformé en course au statut ACCEPTE")
    void should_accept_a_command_to_make_a_course_status_ACCEPTED() {
        // Given
        var commande = CommandeEntity.builder().id(UUID.randomUUID()).build();

        // When
        CourseEntity course = selectionnerCommandeDomainService.selectionnerCommande(commande);

        // Then
        assertEquals(course.getStatut(), StatutCourse.ACCEPTED);
    }
}
