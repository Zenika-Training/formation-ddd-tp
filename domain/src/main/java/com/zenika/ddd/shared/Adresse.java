package com.zenika.ddd.shared;

import lombok.Builder;

@Builder
public record Adresse(String numero, String rue, String codePostal, String ville) {
}
