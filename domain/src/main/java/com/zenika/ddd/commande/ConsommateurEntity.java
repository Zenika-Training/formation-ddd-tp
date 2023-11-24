package com.zenika.ddd.commande;

import com.zenika.ddd.doc.DomainObject;
import com.zenika.ddd.shared.Adresse;
import lombok.*;

@Getter
@RequiredArgsConstructor
@Builder
@DomainObject
public class ConsommateurEntity {

    @NonNull
    private String nom;

    @NonNull
    private String prenom;

    @NonNull
    private Adresse adresse;

}
