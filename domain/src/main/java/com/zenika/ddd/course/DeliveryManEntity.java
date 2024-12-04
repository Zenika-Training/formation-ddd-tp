package com.zenika.ddd.course;

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

    public static DeliveryManEntityBuilder builder() {
        return new DeliveryManEntityBuilder();
    }

    public static class DeliveryManEntityBuilder {
        private UUID id;
        private String nom;
        private String prenom;
        private String email;
        private Position position;

        public DeliveryManEntityBuilder id(UUID id) {
            this.id = id;
            return this;
        }

        public DeliveryManEntityBuilder nom(String nom) {
            this.nom = nom;
            return this;
        }

        public DeliveryManEntityBuilder prenom(String prenom) {
            this.prenom = prenom;
            return this;
        }

        public DeliveryManEntityBuilder email(String email) {
            this.email = email;
            return this;
        }

        public DeliveryManEntityBuilder position(Position position) {
            this.position = position;
            return this;
        }

        public DeliveryManEntity build() {
            return new DeliveryManEntity(this.nom, this.prenom, this.position, this.email);
        }
    }

    public UUID getId() {
        return this.id;
    }

    public String getNom() {
        return this.nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public Position getPosition() {
        return this.position;
    }
}
