package com.brett.catalog.infrastructure;

import com.brett.Event;
import com.brett.EventBus;
import org.springframework.stereotype.Component;

//@Component
public class ActiveMQEventBus implements EventBus {
    @Override
    public void sendEvent(Event event) {
        // implement technical logic of sending to ActiveMQ
    }
}
