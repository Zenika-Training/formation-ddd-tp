package com.zenika.ddd.aggregateorder;

public class ReadyOrderCannotBeRejected extends Throwable {

    public ReadyOrderCannotBeRejected(Order order) {
    }
}
