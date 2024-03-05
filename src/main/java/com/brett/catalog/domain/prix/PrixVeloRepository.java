package com.brett.catalog.domain.prix;

import com.brett.catalog.domain.velo.CodeModeleVelo;

public interface PrixVeloRepository {

    PrixVelo getPrixVelo(CodeModeleVelo codeModeleVelo);

    void addPrix(PrixVelo prixBmx);
}
