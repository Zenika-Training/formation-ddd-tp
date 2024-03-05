package com.brett.catalog.infrastructure.velo;

import com.brett.catalog.domain.velo.CodeModeleVelo;
import com.brett.catalog.domain.velo.ModeleDeVelo;
import com.brett.catalog.domain.velo.ModeleVeloRepository;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class JDBCModeleVeloRepository implements ModeleVeloRepository {
    private Map<CodeModeleVelo, ModeleDeVelo> modelesDeVelo = new HashMap<>();


    @Override
    public List<ModeleDeVelo> findAllModelesDeVelo() {
        return modelesDeVelo.values().stream().toList();
    }

    @Override
    public void addModele(ModeleDeVelo modele) {
        this.modelesDeVelo.put(modele.getCodeModele(), modele);
    }
}
