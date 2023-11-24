package com.zenika.ddd.commande;

import com.zenika.ddd.doc.ValueObject;

import java.util.List;

@ValueObject
public record PlatVO(String nom, double prix, List<byte[]> images) {
}
