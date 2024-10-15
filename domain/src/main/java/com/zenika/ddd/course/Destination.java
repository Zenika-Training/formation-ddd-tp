package com.zenika.ddd.course;

import com.zenika.ddd.shared.Adresse;
import lombok.Builder;

@Builder(toBuilder = true)
public record Destination(Adresse adresse, String nom, Double latitude, Double longitude) {
}
