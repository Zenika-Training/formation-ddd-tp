package com.zenika.ddd.course;

import com.zenika.ddd.shared.Adresse;
import com.zenika.ddd.shared.Position;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Builder
@Getter
public class LivreurEntity {
    private UUID id;
    private String nom;
    private String prenom;
    private String email;
    private Position position;
    private Adresse adresse;

    public void createCoursier(String nom, String prenom, String email, Adresse adresse) {
        LivreurEntity.builder()
                         .id(UUID.randomUUID())
                         .nom(nom)
                         .prenom(prenom)
                         .email(email)
                         .adresse(adresse)
                         .build();
    }

    public void moveToPosition(Position position, float distance) {
        while (!position.isCloseToPosition(this.position, distance)) {
            if (position.latitude() > this.position.latitude()) {
                this.position = new Position(this.position.latitude() + 0.0002, this.position.longitude());
            }
            if (position.latitude() < this.position.latitude()) {
                this.position = new Position(this.position.latitude() - 0.0002, this.position.longitude());
            }
            if (position.longitude() > this.position.longitude()) {
                this.position = new Position(this.position.latitude(), this.position.longitude() + 0.0002);
            }
            if (position.longitude() < this.position.longitude()) {
                this.position = new Position(this.position.latitude(), this.position.longitude() - 0.0002);
            }

            System.out.println("Delivery person " + this.nom + " moved to position " + this.position);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
