package com.zenika.ddd.commande;

import com.zenika.ddd.doc.DomainObject;
import com.zenika.ddd.shared.Adresse;

@DomainObject
public class ConsumerEntity {

    private String nom;
    private String prenom;
    private Adresse adresse;

}
