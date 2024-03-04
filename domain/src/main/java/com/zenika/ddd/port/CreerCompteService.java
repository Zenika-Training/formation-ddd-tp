package com.zenika.ddd.port;

import com.zenika.ddd.shared.Adresse;

public interface CreerCompteService {
    void creerCompte(String nom, String prenom, String email, Adresse adresse);
}
