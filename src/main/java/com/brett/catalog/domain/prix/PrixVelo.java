package com.brett.catalog.domain.prix;

import com.brett.Aggregate;
import com.brett.catalog.domain.velo.CodeModeleVelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Aggregate
public class PrixVelo {
    private final PrixVeloId id;
    private final CodeModeleVelo codeModele;
    private final List<PrixParJour> prixParJour;

    public PrixVelo(CodeModeleVelo codeModeleVelo, PrixParJour prixParJour) {
        this.id = PrixVeloId.generate();
        this.codeModele = codeModeleVelo;
        this.prixParJour = new ArrayList<>();
        this.prixParJour.add(prixParJour);
    }

    public void changementPrix(PrixParJour nouveauPrix) {
        this.prixParJour.add(nouveauPrix);
    }

    public PrixParJour prixEffectif(LocalDate date) {
        // simplified implementation
        return prixParJour.get(prixParJour.size() - 1);
    }

    public CodeModeleVelo getCodeModele() {
        return codeModele;
    }

    public PrixVeloId getId() {
        return this.id;
    }
}
