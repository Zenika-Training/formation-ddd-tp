package com.zenika.ddd.course;

import com.zenika.ddd.shared.Adresse;
import com.zenika.ddd.shared.Position;

import java.util.UUID;

public class DeliveryManEntity {
    private UUID id;
    private String nom;
    private String prenom;
    private String email;
    private Position position;

    public DeliveryManEntity(String nom, String prenom, Position position, String mail) {
        this.id = UUID.randomUUID();
        this.nom = nom;
        this.prenom = prenom;
        this.position = position;
        this.email = mail;
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

    public Position getPosition() {
        return this.position;
    }
}
