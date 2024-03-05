package com.zenika.ddd.subdomaindelivery.deliveryman;

import com.zenika.ddd.shared.Adresse;

public record Destination(Adresse adresse, String nom) {
}
