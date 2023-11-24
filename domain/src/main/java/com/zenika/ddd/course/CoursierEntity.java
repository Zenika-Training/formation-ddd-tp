package com.zenika.ddd.course;

import com.zenika.ddd.shared.Adresse;
import com.zenika.ddd.shared.Position;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Builder
@Getter
public class CoursierEntity {
    private UUID id;
    private String nom;
    private String prenom;
    private String email;
    private Position position;
    private Adresse adresse;

    public void createCoursier(String nom, String prenom, String email, Adresse adresse) {
        CoursierEntity.builder()
                .id(UUID.randomUUID())
                .nom(nom)
                .prenom(prenom)
                .email(email)
                .adresse(adresse)
                .build();
    }

    public Position moveToPosition(Position position) {
        if (position.latitude() > this.position.latitude()) {
            this.position = new Position(this.position.latitude() + 1, this.position.longitude());
        }
        if (position.latitude() < this.position.latitude()) {
            this.position = new Position(this.position.latitude() - 1, this.position.longitude());
        }
        if (position.longitude() > this.position.longitude()) {
            this.position = new Position(this.position.latitude(), this.position.longitude() + 1);
        }
        if (position.longitude() < this.position.longitude()) {
            this.position = new Position(this.position.latitude(), this.position.longitude() - 1);
        }

        System.out.println("Delivery person " + this.nom + " moved to position " + this.position);

        return this.position;
    }

    public boolean isCloseToRestaurant(Position position) {
        return Math.pow(this.position.latitude() - position.latitude(), 2) < 4 && Math.pow(this.position.longitude() - position.longitude(), 2) < 4;
    }
}
