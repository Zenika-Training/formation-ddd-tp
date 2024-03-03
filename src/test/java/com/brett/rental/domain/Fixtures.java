package com.brett.rental.domain;

import com.brett.rental.domain.bike.Bike;
import com.brett.rental.domain.bike.Make;
import com.brett.rental.domain.bike.Model;
import com.brett.rental.domain.station.Capacity;
import com.brett.rental.domain.station.Station;
import com.brett.rental.domain.station.StationName;
import com.brett.rental.domain.station.StationType;

public class Fixtures {

    public static Station parisStation() {
        return Station.create(StationName.of("Paris"), StationType.BrettShop, Capacity.of(10));
    }

    public static Make decathlon = Make.of("Decathlon");
    public static Make peugeot = Make.of("Peugeot");
    public static Make BMC = Make.of("BMC");
    public static Model vanrysel = Model.of("Van Rysel EDR CF Ultegra Disc Road Bike");
    public static Model ec01 = Model.of("eC01-100 Electric Bike");
    public static Model teammachine = Model.of("Teammachine SLR01 One");
    public static Bike vanryselBike = Bike.of(decathlon, vanrysel);
    public static Bike ec01Bike = Bike.of(peugeot, ec01);
    public static Bike teammachineBike = Bike.of(BMC, teammachine);
}
