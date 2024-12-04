package com.zenika.ddd.course;

import com.zenika.ddd.shared.Adresse;
import com.zenika.ddd.shared.Position;

import java.util.UUID;

public class RestaurantEntity {
    private UUID id;
    private String raisonSociale;
    private Adresse adresse;
    private Position position;
}
