package com.brett.rental.domain.station;

import com.brett.rental.domain.bike.Bike;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Getter
public class Station {
    private StationId stationId;
    private StationName name;
    private StationType type;
    private Capacity capacity;
    private Map<Bike, Quantity> bikeQuantity;

    public static Station create(StationName name, StationType stationType, Capacity capacity) {
        return new Station(StationId.generate(), name, stationType, capacity, new HashMap<>());
    }

    public Station(StationId stationId, StationName name, StationType type, Capacity capacity, Map<Bike, Quantity> bikeQuantity) {
        this.stationId = stationId;
        this.name = name;
        this.type = type;
        this.capacity = capacity;
        this.bikeQuantity = bikeQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Station station = (Station) o;
        return Objects.equals(stationId, station.stationId) && Objects.equals(name, station.name) && type == station.type && Objects.equals(capacity, station.capacity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stationId, name, type, capacity);
    }

    public void enterInStock(Entry entry) {
        if (inventorySize() + entry.quantity().amount() > capacity.amount()) {
            throw new NotEnoughCapacityInStation(stationId, name, capacity, inventorySize(), entry.quantity());
        }
        bikeQuantity.merge(entry.bike(), entry.quantity(), Quantity::add);
    }

    public int inventorySize() {
        return bikeQuantity.values().stream().mapToInt(Quantity::amount).sum();
    }

    public Inventory inventory() {
        return new Inventory(
                Map.copyOf(bikeQuantity)
        );
    }
}
