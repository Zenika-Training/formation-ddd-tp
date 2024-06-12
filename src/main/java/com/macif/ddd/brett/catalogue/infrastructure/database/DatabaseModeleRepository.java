package com.macif.ddd.brett.catalogue.infrastructure.database;

import com.macif.ddd.brett.catalogue.domain.model.Modele;
import com.macif.ddd.brett.catalogue.domain.repository.ModeleRepository;
import org.springframework.ui.Model;

import java.util.List;
import java.util.UUID;
import java.util.stream.StreamSupport;

public class DatabaseModeleRepository implements ModeleRepository {

    private final SpringDataModelRepository springDataModelRepository;

    public DatabaseModeleRepository(SpringDataModelRepository springDataModelRepository) {
        this.springDataModelRepository = springDataModelRepository;
    }

    @Override
    public List<Modele> listerModele() {
        return springDataModelRepository
                .findAll()
                .stream()
                .map(this::toModel).toList();
    }

    @Override
    public void ajouterModele(Modele modele) {
        var entity = toEntity(modele);
        springDataModelRepository.save(entity);
    }

    @Override
    public void retirerModele(UUID modeleId) {
        springDataModelRepository.deleteById(modeleId);
    }

    ModeleEntity toEntity(Modele modele) {
        var entity = new ModeleEntity();
        entity.setId(modele.getId());
        entity.setNom(modele.getNom());
        return entity;
    }

    Modele toModel(ModeleEntity entity) {
        return Modele.builder()
                .id(entity.getId())
                .nom(entity.getNom())
                .build();
    }

}
