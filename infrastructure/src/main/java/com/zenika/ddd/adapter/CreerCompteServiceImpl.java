package com.zenika.ddd.adapter;

import com.zenika.ddd.port.CreerCompteService;
import com.zenika.ddd.shared.Adresse;
import com.zenika.ddd.entity.CoursierEntity;
import com.zenika.ddd.adapter.mapper.AdresseMapper;
import com.zenika.ddd.repository.CoursierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CreerCompteServiceImpl implements CreerCompteService {

    private final CoursierRepository coursierRepository;
    private final AdresseMapper adresseMapper;

    @Override
    public void creerCompte(String nom, String prenom, String email, Adresse adresse) {
        CoursierEntity coursierEntity = CoursierEntity.builder()
                .lastName(nom)
                .firstName(prenom)
                .email(email)
                .adresse(adresseMapper.toAdresseEntity(adresse))
                .build();
        coursierRepository.save(coursierEntity);
    }
}
