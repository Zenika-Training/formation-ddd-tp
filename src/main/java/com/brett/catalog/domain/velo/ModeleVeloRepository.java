package com.brett.catalog.domain.velo;

import java.util.List;

public interface ModeleVeloRepository {

    List<ModeleDeVelo> findAllModelesDeVelo();

    void addModele(ModeleDeVelo modele);
}
