package com.zenika.ddd.subdomaindelivery.deliveryman;

import com.zenika.ddd.shared.Adresse;
import com.zenika.ddd.shared.Position;
import lombok.Builder;

import java.util.UUID;

@Builder
public class RestaurantEntity {
    private UUID id;
    private Adresse adresse;
    private Position position;
}

