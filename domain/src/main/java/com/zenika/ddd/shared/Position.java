package com.zenika.ddd.shared;

import com.zenika.ddd.doc.ValueObject;

@ValueObject
public record Position(double latitude, double longitude) {
    public boolean isCloseToPosition(Position position, float distance) {
        return Math.pow(this.latitude() - position.latitude(), 2) < distance && Math.pow(this.longitude() - position.longitude(), 2) < distance;
    }
}
