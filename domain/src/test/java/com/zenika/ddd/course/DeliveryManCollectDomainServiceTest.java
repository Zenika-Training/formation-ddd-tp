package com.zenika.ddd.course;

import com.zenika.ddd.commande.OrderEntity;
import com.zenika.ddd.commande.OrderStatus;
import com.zenika.ddd.shared.Position;
import jdk.jfr.Description;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeliveryManCollectDomainServiceTest {

    private DeliveryManCollectDomainService deliveryManCollectDomainService = new DeliveryManCollectDomainService();

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
        order.deliveryManAcceptedTheOrder(deliveryMan);
        deliveryManCollectDomainService.acceptAndCollectOrder(order);

        // Then
        assertTrue(deliveryMan.getPosition().isCloseToPosition(restaurant.getPosition(), 0.0001f));
        assertEquals(order.getOrderStatus(), OrderStatus.COLLECTED);
    }
}
