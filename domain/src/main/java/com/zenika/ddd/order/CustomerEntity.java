package com.zenika.ddd.order;

import com.zenika.ddd.doc.DomainObject;
import com.zenika.ddd.shared.Adresse;
import lombok.*;

@Getter
@RequiredArgsConstructor
@NoArgsConstructor
@Builder
@DomainObject
public class CustomerEntity {

    @NonNull
    private String nom;

    @NonNull
    private String prenom;

    @NonNull
    private Adresse adresse;

}
