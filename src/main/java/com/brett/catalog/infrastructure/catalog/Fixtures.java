package com.brett.catalog.infrastructure.catalog;

import com.brett.catalog.domain.prix.PrixJournalierEnCentime;
import com.brett.catalog.domain.prix.PrixParJour;
import com.brett.catalog.domain.velo.CodeModeleVelo;
import com.brett.catalog.domain.velo.ModeleDeVelo;

import java.time.LocalDate;
import java.time.Month;

public class Fixtures {

    public static CodeModeleVelo codeModeleBMX = new CodeModeleVelo("BMX");
    public static CodeModeleVelo codeModeleDecathlon = new CodeModeleVelo("Decathlon");

    public static ModeleDeVelo veloBmx() {
        return new ModeleDeVelo(codeModeleBMX);
    }
    public static ModeleDeVelo veloDecathlon() {
        return new ModeleDeVelo(codeModeleDecathlon);
    }



    public static LocalDate fourOfMarch = LocalDate.of(2024, Month.MARCH, 4);
    public static LocalDate  fifthOfMarch = LocalDate.of(2024, Month.MARCH, 5);
    public static LocalDate sixthOfMarch = LocalDate.of(2024, Month.MARCH, 6);

    public static PrixParJour euros45ParJour = new PrixParJour(
            new PrixJournalierEnCentime(4500),
            fourOfMarch
    );

    public static PrixParJour euros55ParJour = new PrixParJour(
            new PrixJournalierEnCentime(5500),
            fifthOfMarch
    );
}
