package com.zenika.ddd.subdomaindelivery.order;

import com.zenika.ddd.doc.ValueObject;
import lombok.Builder;

import java.util.List;

@ValueObject
@Builder
public record Item(String nom, double prix, List<byte[]> images) {
}
