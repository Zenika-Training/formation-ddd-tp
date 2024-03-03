package com.brett.rental.domain.station;

import com.brett.rental.domain.Fixtures;
import com.brett.rental.domain.station.Entry;
import com.brett.rental.domain.station.NotEnoughCapacityInStation;
import com.brett.rental.domain.station.Quantity;
import com.brett.rental.domain.station.Station;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static com.brett.rental.domain.Fixtures.*;
import static org.junit.jupiter.api.Assertions.*;

public class StationTests {

    @Test
    public void enterBikesInStock() {
        var station = Fixtures.parisStation();

        station.enterInStock(Entry.of(vanryselBike, Quantity.of(5)));

        assertEquals(5, station.inventorySize());
        assertTrue(station.getCapacity().amount() >= station.inventorySize());
    }

    @Test
    public void enterMultipleBikesOfSameModelInStock() {
        var station = Fixtures.parisStation();

        station.enterInStock(Entry.of(vanryselBike, Quantity.of(5)));
        station.enterInStock(Entry.of(vanryselBike, Quantity.of(3)));

        assertEquals(8, station.inventorySize());
        assertTrue(station.getCapacity().amount() >= station.inventorySize());
    }

    @Test
    public void cantEnterMoreBikesThanThereIsCapacity() {
        var station = Fixtures.parisStation();

        station.enterInStock(Entry.of(vanryselBike, Quantity.of(station.getCapacity().amount())));

        assertThrows(NotEnoughCapacityInStation.class, () -> station.enterInStock(Entry.of(vanryselBike, Quantity.of(5))));
    }

    @Test
    public void seeStationInventory() {
        var station = Fixtures.parisStation();

        station.enterInStock(Entry.of(vanryselBike, Quantity.of(5)));
        station.enterInStock(Entry.of(ec01Bike, Quantity.of(2)));
        station.enterInStock(Entry.of(teammachineBike, Quantity.of(3)));

        assertEquals(
                Inventory.of(Map.of(
                        vanryselBike, Quantity.of(5),
                        ec01Bike, Quantity.of(2),
                        teammachineBike, Quantity.of(3))),
                station.inventory());
    }
}
