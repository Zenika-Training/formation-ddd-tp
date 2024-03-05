package com.zenika.ddd.subdomainrestaurant;

import com.zenika.ddd.shared.Adresse;
import com.zenika.ddd.shared.Position;
import com.zenika.ddd.subdomaindelivery.deliveryman.DeliveryManEntity;
import com.zenika.ddd.subdomaindelivery.deliveryman.RestaurantEntity;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CollectReadyOrdersServiceTest {

    private final CollectReadyOrdersService collectReadyOrdersService = new CollectReadyOrdersService();


    @Test
    @DisplayName("The restaurant should start the order preparation when a delivery man approaches the restaurant")
    void should_start_order_preparation() throws OrderNotAcceptedException, DeliveryManTooFarException, OrderNotReadyException {
        // Given
        RestaurantEntity restaurant = RestaurantEntity.builder()
                .id(UUID.randomUUID())
                .adresse(new Adresse("1", "rue de la paix", "Paris", "75000"))
                .position(new Position(48.8566, 2.3521))
                .build();
        Order order = new Order(List.of(Item.builder()
                                            .status(EnumStatusItem.TERMINATED)
                                            .name("Pizza")
                                            .build()));
        order.accept();
        order.startPreparation();
        order.isCompleted();
        DeliveryManEntity man = DeliveryManEntity.builder()
                                                 .id(UUID.randomUUID())
                                                 .nom("Oucesoir")
                                                 .prenom("Ondine")
                                                 .position(new Position(48.8766, 2.3622))
                                                 .build();
        man.moveToPosition(restaurant.getPosition(), 0.001f);

        // When
        collectReadyOrdersService.CollectOrder(order, man, restaurant);


        // Then
        boolean inTransit = order.isInTransit();
        assertTrue(inTransit);
    }

    @SneakyThrows
    @Test
    @DisplayName("The delivery should collect the order when the order is ready")
    void should_collect_order_when_ready() {
        Order order = new Order(List.of());
        order.accept();
        order.startPreparation();
        order.isCompleted();
    }

}
