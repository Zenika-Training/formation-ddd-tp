package com.zenika.ddd.domain.commande;

import com.zenika.ddd.domain.shared.Adresse;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
public class ConsommateurEntity {

    @NonNull
    private String nom;

    @NonNull
    private String prenom;

    @NonNull
    private Adresse adresse;

}
