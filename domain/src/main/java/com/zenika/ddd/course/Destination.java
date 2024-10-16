package com.zenika.ddd.course;

import com.zenika.ddd.shared.Adresse;
import com.zenika.ddd.shared.Position;
import lombok.Builder;

@Builder(toBuilder = true)
public record Destination(Adresse adresse, String nom, Double latitude, Double longitude) {

    public Position toPosition() {
        return  Position.builder()
                .longitude(this.longitude)
                .latitude(this.latitude).build();
    }
}

