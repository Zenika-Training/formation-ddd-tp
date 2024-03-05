package com.brett.catalog.domain.prix;

import com.brett.catalog.domain.prix.PrixVelo;
import org.junit.jupiter.api.Test;

import static com.brett.catalog.domain.Fixtures.*;
import static org.junit.jupiter.api.Assertions.*;

class PrixVeloTest {

    @Test
    public void canChangePrice() {
        var prixVelo = new PrixVelo(
                codeModeleBMX,
                euros45ParJour
        );
        var oldPrice = prixVelo.prixEffectif(sixthOfMarch);
        assertEquals(oldPrice, euros45ParJour);

        prixVelo.changementPrix(euros55ParJour);
        var newPrice = prixVelo.prixEffectif(sixthOfMarch);
        assertEquals(newPrice, euros55ParJour);
    }

}