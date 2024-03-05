package com.zenika.ddd.subdomainrestaurant;

public class OrderNotAcceptedException extends Throwable {

    public OrderNotAcceptedException(Order order) {
    }
}
