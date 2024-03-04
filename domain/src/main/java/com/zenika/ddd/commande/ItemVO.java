package com.zenika.ddd.commande;

import com.zenika.ddd.doc.ValueObject;
import lombok.Builder;

import java.util.List;

@ValueObject
@Builder
public record ItemVO(String nom, double prix, List<byte[]> images) {
}
