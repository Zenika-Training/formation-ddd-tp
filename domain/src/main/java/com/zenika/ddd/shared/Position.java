package com.zenika.ddd.shared;

import lombok.Builder;

@Builder(toBuilder = true)
public record Position(double latitude, double longitude) {
    public boolean isCloseToPosition(Position position, float distance) {
        return this.distance(position) < distance;
    }

    public double distance(Position position) {
        return Math.sqrt(Math.pow(this.latitude() - position.latitude(), 2) + Math.pow(this.longitude() - position.longitude(), 2));
    }


}
