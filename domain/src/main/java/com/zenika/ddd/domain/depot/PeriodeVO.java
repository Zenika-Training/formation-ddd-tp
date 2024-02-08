package com.zenika.ddd.domain.depot;

import com.zenika.ddd.doc.ValueObject;

import java.util.Objects;

@ValueObject
public record PeriodeVO(IntervalDateVO intervalDateVO, String anneeUniversitaire) {
    public PeriodeVO {
        Objects.requireNonNull(intervalDateVO.dateDebut() , "La date de début ne doit pas être vide");
        Objects.requireNonNull(intervalDateVO.dateFin() , "La date de fin ne doit pas être vide");
        Objects.requireNonNull(anneeUniversitaire , "L'année universitaire ne doit pas être vide");
    }
}
