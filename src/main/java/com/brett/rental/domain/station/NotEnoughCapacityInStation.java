package com.brett.rental.domain.station;

public class NotEnoughCapacityInStation extends RuntimeException {
    private final StationId stationId;
    private final StationName stationName;
    private final Capacity capacity;
    private final int inventorySize;
    private final Quantity quantity;

    public NotEnoughCapacityInStation(StationId stationId, StationName stationName, Capacity capacity, int inventorySize, Quantity quantity) {
        super("Not able to add %d bikes to station %s (%s), station capacity is %d, current inventory size is %d, trying to add %d bikes".formatted(quantity.amount(), stationName, stationId, capacity.amount(), inventorySize, quantity.amount()));
        this.stationId = stationId;
        this.stationName = stationName;
        this.capacity = capacity;
        this.inventorySize = inventorySize;
        this.quantity = quantity;
    }
}
