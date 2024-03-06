package com.brett;

import java.time.LocalDate;
import java.util.UUID;

public interface Event {
    UUID id();
    LocalDate date();
    String eventType();
}
