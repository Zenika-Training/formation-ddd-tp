package com.zenika.ddd.commande;

import com.zenika.ddd.doc.ValueObject;

@ValueObject
public record ItemVO(String nom, double prix) {
}
