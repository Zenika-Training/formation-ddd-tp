package com.zenika.ddd.aggregatedelivery;

import com.zenika.ddd.shared.Adresse;
import com.zenika.ddd.shared.Position;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Builder
@Getter
public class DeliveryManEntity {
    private UUID id;
    private String nom;
    private String prenom;
    private String email;
    private Position position;
    private Adresse adresse;


    public void moveToPosition(Position position, float distance) {
        while (!position.isCloseToPosition(this.position, distance)) {
            if (position.latitude() > this.position.latitude()) {
                double dist = Math.min(0.0002, position.latitude() -  this.position.latitude());
                this.position = new Position(this.position.latitude() + dist, this.position.longitude());
            }
            if (position.latitude() < this.position.latitude()) {
                double dist = Math.min(0.0002, this.position.latitude() - position.latitude() );
                this.position = new Position(this.position.latitude() - dist, this.position.longitude());
            }
            if (position.longitude() > this.position.longitude()) {
                double dist = Math.min(0.0002, this.position.latitude() - position.latitude() );
                this.position = new Position(this.position.latitude(), this.position.longitude() + dist);
            }
            if (position.longitude() < this.position.longitude()) {
                double dist = Math.min(0.0002, this.position.longitude() - position.longitude() );
                this.position = new Position(this.position.latitude(), this.position.longitude() - dist);
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
