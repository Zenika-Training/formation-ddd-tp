package com.zenika.ddd.order;

import com.zenika.ddd.doc.ValueObject;

@ValueObject
public record ItemVO(String nom, double prix) {
}
