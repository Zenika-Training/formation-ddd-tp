package com.zenika.ddd.domain.course;

import com.zenika.ddd.domain.shared.Adresse;
import com.zenika.ddd.domain.shared.Position;

import java.util.UUID;

public class RestaurantEntity {
    private UUID id;
    private String raisonSociale;
    private Adresse adresse;
    private Position position;
}
