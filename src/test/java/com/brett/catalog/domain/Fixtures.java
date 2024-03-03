package com.brett.catalog.domain;

import java.util.HashMap;
import java.util.Map;

public class Fixtures {

    public static Reference vanRyselReference() {
        return Reference.make(
                Code.generate(),
                "Van Rysel EDR CF Ultegra Disc Road Bike",
                """
                        The Van Rysel EDR CF Ultegra Disc Road Bike is a high-performance road bike designed for riders 
                        seeking both speed and comfort on long rides. Its frame is constructed from carbon fiber, offering  
                        a blend of lightweight and rigidity that translates into efficient power transfer and responsive 
                        handling.""",
                new PricePerDay(new AmountInCents(30)),
                new HashMap<>(Map.of("type", "road",
                        "frame", "mixed",
                        "characteristic", "lightweight",
                        "usage", "adventure"))
        );
    }
}
