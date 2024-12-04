package com.zenika.ddd.order;

import com.zenika.ddd.course.DeliveryManEntity;
import com.zenika.ddd.doc.DomainObject;
import com.zenika.ddd.shared.Position;

@DomainObject
public class CustomerEntity {

    private String nom;
    private String prenom;
    private Position position;

    public CustomerEntity(String nom, String prenom, Position position) {
        this.nom = nom;
        this.prenom = prenom;
        this.position = position;
    }

    public static CustomerEntityBuilder builder() {
        return new CustomerEntityBuilder();
    }

    public static class CustomerEntityBuilder {
        private String nom;
        private String prenom;
        private Position position;

        public CustomerEntityBuilder nom(String nom) {
            this.nom = nom;
            return this;
        }

        public CustomerEntityBuilder prenom(String prenom) {
            this.prenom = prenom;
            return this;
        }

        public CustomerEntityBuilder position(Position position) {
            this.position = position;
            return this;
        }

        public CustomerEntity build() {
            return new CustomerEntity(nom, prenom, position);
        }
    }
}
