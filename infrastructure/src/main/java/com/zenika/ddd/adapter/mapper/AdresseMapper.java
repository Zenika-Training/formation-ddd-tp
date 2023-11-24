package com.zenika.ddd.adapter.mapper;

import com.zenika.ddd.shared.Adresse;
import com.zenika.ddd.entity.AdresseEntity;
import org.springframework.stereotype.Component;

@Component
public class AdresseMapper {

    public AdresseEntity toAdresseEntity(Adresse adresse) {
        return AdresseEntity.builder()
                .street(adresse.rue())
                .city(adresse.ville())
                .zipCode(adresse.codePostal())
                .build();
    }
}
