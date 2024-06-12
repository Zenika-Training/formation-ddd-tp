package com.zenika.ddd.course;

import com.zenika.ddd.commande.OrderEntity;
import com.zenika.ddd.commande.OrderStatus;
import com.zenika.ddd.shared.Position;
import jdk.jfr.Description;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DeliveryManEntityTest {

    @Test
    void delivery_man_should_move_to_position() {
        // Given
        DeliveryManEntity deliveryMan = DeliveryManEntity.builder()
                                                         .nom("Outan")
                                                         .prenom("Laurent")
                                                         .position(new Position(47.216620, -1.577638))
                                                         .email("laurent.outant@gmail.com")
                                                         .build();
        Position destinationPosition = new Position(47.211912, -1.561013);

        // When
        deliveryMan.moveToPosition(destinationPosition, 0.0001f);

        // Then
        assertTrue(deliveryMan.getPosition().isCloseToPosition(destinationPosition, 0.001f));

    }

    @Test
    @Description("When a deliveryMan accepts an order, then it moves to the restaurant to collect the order")
    void should_collect_order_from_restaurant() {
        // Given
        DeliveryManEntity deliveryMan = DeliveryManEntity.builder()
                .nom("Outan")
                .prenom("Laurent")
                .position(new Position(47.216620, -1.577638))
                .build();
        RestaurantEntity restaurant = RestaurantEntity.builder().position(new Position(47.211912, -1.561013)).build();

        OrderEntity order = OrderEntity.builder().restaurantEntity(restaurant).build();

        // When
        deliveryMan.moveToCollectOrder(order);

        // Then
        assertTrue(deliveryMan.getPosition().isCloseToPosition(restaurant.getPosition(), 0.0001f));
    }

    @Test
    @Description("When a deliveryMan is close to the restaurant, then it can collect the order")
    void should_collect_order_from_restaurant_when_close() {
        // Given
        DeliveryManEntity deliveryMan = DeliveryManEntity.builder()
                .nom("Outan")
                .prenom("Laurent")
                .position(new Position(47.211912, -1.561013))
                .build();
        RestaurantEntity restaurant = RestaurantEntity.builder().position(new Position(47.211912, -1.561013)).build();

        OrderEntity order = OrderEntity.builder().restaurantEntity(restaurant).build();

        // When
        deliveryMan.collect(order);

        // Then
        assertEquals(order.getOrderStatus(), OrderStatus.COLLECTED);
    }
}
