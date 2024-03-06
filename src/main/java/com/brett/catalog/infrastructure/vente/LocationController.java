package com.brett.catalog.infrastructure.vente;

import com.brett.catalog.application.DemandeDeLocation;
import com.brett.catalog.domain.vente.LieuDePickup;
import com.brett.catalog.domain.vente.TypeLieuDePickup;
import com.brett.catalog.infrastructure.catalog.Fixtures;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@RestController
public class LocationController {

    @Autowired
    DemandeDeLocation demandeDeLocation;

    @PostMapping("/location")
    public void createNewDemandeDeLocation(/* ... */) {
        demandeDeLocation.handleDemandeLocation(
                new LieuDePickup(TypeLieuDePickup.MagasinPartenaire, "Carrefour123"),
                LocalDate.now(),
                LocalDate.now().plusDays(1),
                List.of(
                        Fixtures.veloBmx(),
                        Fixtures.veloBmx(),
                        Fixtures.veloBmx(),
                        Fixtures.veloBmx()
                )
        );
    }

}
