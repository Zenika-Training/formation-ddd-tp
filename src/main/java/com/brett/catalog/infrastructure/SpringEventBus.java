package com.brett.catalog.infrastructure;

import com.brett.Event;
import com.brett.EventBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class SpringEventBus implements EventBus {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void sendEvent(Event event) {
        applicationEventPublisher.publishEvent(event);
    }
}
