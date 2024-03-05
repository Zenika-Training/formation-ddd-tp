package com.brett.catalog.domain.catalog;

import com.brett.catalog.domain.prix.PrixVelo;
import com.brett.catalog.domain.velo.ModeleDeVelo;

public record VeloAndPrix(ModeleDeVelo modeleDeVelo, PrixVelo prix) {
}
