package com.zenika.ddd.domain.commande;

import java.util.List;

public record PlatVO(String nom, double prix, List<byte[]> images) {
}
