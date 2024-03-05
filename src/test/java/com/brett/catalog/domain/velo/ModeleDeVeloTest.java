package com.brett.catalog.domain.velo;

import com.brett.catalog.domain.Fixtures;
import com.brett.catalog.domain.velo.ModeleDeVelo;
import com.brett.catalog.domain.velo.ModeleDeVeloException;
import com.brett.catalog.domain.velo.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ModeleDeVeloTest {

    @Test
    public void cantAddTagToRetiredModeleDeVelo() {
        ModeleDeVelo modeleDeVelo = new ModeleDeVelo(Fixtures.codeModeleBMX);
        modeleDeVelo.retireFromCatalog();
        assertThrows(ModeleDeVeloException.class, () -> modeleDeVelo.addTag(new Tag("Cadre Alluminium")));
    }

}