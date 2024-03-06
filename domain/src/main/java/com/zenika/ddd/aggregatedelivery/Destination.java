package com.zenika.ddd.aggregatedelivery;

import com.zenika.ddd.shared.Adresse;

public record Destination(Adresse adresse, String nom) {
}
