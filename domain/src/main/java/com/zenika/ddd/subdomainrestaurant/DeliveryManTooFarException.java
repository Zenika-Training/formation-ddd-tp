package com.zenika.ddd.subdomainrestaurant;

public class DeliveryManTooFarException extends Exception {
    DeliveryManTooFarException() {
        super("The delivery man is not at the restaurant to collect the order");
    }
}
