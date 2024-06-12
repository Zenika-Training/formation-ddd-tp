package com.macif.ddd.brett.catalogue.domain.repository;

import com.macif.ddd.brett.catalogue.domain.model.Modele;

import java.util.List;
import java.util.UUID;

public interface ModeleRepository {

    List<Modele> listerModele();

    void ajouterModele(Modele modele);

    void retirerModele(UUID modeleId);

}
