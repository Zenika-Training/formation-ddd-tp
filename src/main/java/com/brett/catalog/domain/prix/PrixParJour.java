package com.brett.catalog.domain.prix;

import com.brett.ValueObject;

import java.time.LocalDate;

@ValueObject
public record PrixParJour(PrixJournalierEnCentime prixJournalier, LocalDate dateEffective) {
}
