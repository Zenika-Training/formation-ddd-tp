package com.zenika.ddd.aggregateorder;

public class DeliveryManTooFarException extends Exception {
    DeliveryManTooFarException() {
        super("The delivery man is not at the restaurant to collect the order");
    }
}
