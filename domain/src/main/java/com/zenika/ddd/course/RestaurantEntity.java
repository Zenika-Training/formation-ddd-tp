package com.zenika.ddd.course;

import com.zenika.ddd.shared.Adresse;
import com.zenika.ddd.shared.Position;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Builder
public class RestaurantEntity {
    private UUID id;
    private String raisonSociale;
    private Adresse adresse;
    private Position position;

    public Position getPosition() {
        return this.position.clone();
    }
}
