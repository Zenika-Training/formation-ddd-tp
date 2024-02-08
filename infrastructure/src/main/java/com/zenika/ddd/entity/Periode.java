package com.zenika.ddd.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "periode")
public class Periode {

    private Date dateDebut;
    private Date dateFin;
    private String anneeUniversitaire;

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(final Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(final Date dateFin) {
        this.dateFin = dateFin;
    }

    public String getAnneeUniversitaire() {
        return anneeUniversitaire;
    }

    public void setAnneeUniversitaire(final String anneeUniversitaire) {
        this.anneeUniversitaire = anneeUniversitaire;
    }

}
