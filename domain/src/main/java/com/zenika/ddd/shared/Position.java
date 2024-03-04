package com.zenika.ddd.shared;

public record Position(double latitude, double longitude) {
    public boolean isCloseToPosition(Position position, float distance) {
        return Math.pow(this.latitude() - position.latitude(), 2) < distance && Math.pow(this.longitude() - position.longitude(), 2) < distance;
    }
}
