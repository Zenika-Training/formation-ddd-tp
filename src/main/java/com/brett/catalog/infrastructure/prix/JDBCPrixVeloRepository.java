package com.brett.catalog.infrastructure.prix;

import com.brett.catalog.domain.prix.PrixVelo;
import com.brett.catalog.domain.prix.PrixVeloId;
import com.brett.catalog.domain.prix.PrixVeloRepository;
import com.brett.catalog.domain.velo.CodeModeleVelo;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class JDBCPrixVeloRepository implements PrixVeloRepository {
    private Map<PrixVeloId, PrixVelo> prixVelo = new HashMap<>();

    @Override
    public PrixVelo getPrixVelo(CodeModeleVelo codeModeleVelo) {
        return prixVelo.values().stream()
                .filter(prix -> prix.getCodeModele().equals(codeModeleVelo))
                .findAny()
                .orElseThrow();
    }

    @Override
    public void addPrix(PrixVelo prixBmx) {
        prixVelo.put(prixBmx.getId(), prixBmx);
    }
}
