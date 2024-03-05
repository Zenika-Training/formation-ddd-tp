package com.brett.catalog.domain.prix;

public record PrixJournalierEnCentime(int valeur) {

    public PrixJournalierEnCentime {
        if(valeur < 0) {
            throw new RuntimeException("Price can't be negative");
        }
    }

}
