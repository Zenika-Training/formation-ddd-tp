package com.macif.ddd.brett.catalogue.domain.model;

import java.time.LocalDate;
import java.util.UUID;

public class Offre {

    public UUID id;

    public Double prix;

    public LocalDate dateDebut;

    public LocalDate dateFin;


    public void mettreAJourLePrix(Double prix) {
        this.prix = prix;
    }

    public void mettreAjourLeDebut(LocalDate dateDebut ){
        this.dateDebut = dateDebut;
    }

    public void mettreAjourLaFin(LocalDate dateFin ){
        this.dateFin = dateFin;
    }
}
