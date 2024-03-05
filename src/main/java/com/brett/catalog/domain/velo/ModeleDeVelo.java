package com.brett.catalog.domain.velo;

import com.brett.Aggregate;

import java.util.ArrayList;
import java.util.List;

@Aggregate
public class ModeleDeVelo {
    private final CodeModeleVelo codeModele;
    private Status status;
    private List<Tag> tags;

    public ModeleDeVelo(CodeModeleVelo codeModele) {
        this.status = Status.Actif;
        this.codeModele = codeModele;
        this.tags = new ArrayList<>();
    }

    public void addTag(Tag tag) {
        if(status == Status.Retire) {
            throw new ModeleDeVeloException("This model can't be updated because it is retired");
        }
        tags.add(tag);
    }

    public void retireFromCatalog() {
        if(status == Status.Retire) {
            throw new ModeleDeVeloException("This model is already retired");
        }
        this.status = Status.Retire;
    }

    public CodeModeleVelo getCodeModele() {
        return this.codeModele;
    }
}
