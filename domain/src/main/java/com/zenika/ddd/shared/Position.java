package com.zenika.ddd.shared;

public record Position(double latitude, double longitude) {
    public boolean isCloseToPosition(Position position, float distance) {
        return Math.sqrt(Math.pow(this.latitude() - position.latitude(), 2)  + Math.pow(this.longitude() - position.longitude(), 2)) <= distance;
    }
}
