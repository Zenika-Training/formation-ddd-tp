package com.zenika.ddd.aggregateorder;

public class OrderNotAcceptedException extends Throwable {

    public OrderNotAcceptedException(Order order) {
    }
}
