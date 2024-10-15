package com.zenika.ddd.course;

import com.zenika.ddd.shared.Adresse;
import com.zenika.ddd.shared.Position;
import lombok.Builder;

import java.util.Objects;
import java.util.UUID;

@Builder
public class RestaurantEntity {
    private UUID id;
    private String raisonSociale;
    private Adresse adresse;
    private Position position;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        RestaurantEntity that = (RestaurantEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
