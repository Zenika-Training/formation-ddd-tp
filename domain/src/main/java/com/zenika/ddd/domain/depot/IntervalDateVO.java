package com.zenika.ddd.domain.depot;

import com.zenika.ddd.doc.ValueObject;

import java.time.LocalDate;
import java.util.Objects;

@ValueObject
public record IntervalDateVO(LocalDate dateDebut, LocalDate dateFin) {
    public IntervalDateVO {
        Objects.requireNonNull(dateDebut, "Date de début ne doit pas tre null");
        Objects.requireNonNull(dateFin, "Date de fin ne doit pas tre null");
    }
}
