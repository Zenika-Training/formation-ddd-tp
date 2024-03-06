package com.zenika.ddd.subdomainrestaurant.stub;

import com.zenika.ddd.doc.Stub;
import com.zenika.ddd.subdomainrestaurant.EnumStatusOrder;
import com.zenika.ddd.subdomainrestaurant.Item;
import com.zenika.ddd.subdomainrestaurant.Order;
import com.zenika.ddd.subdomainrestaurant.out.OrderRepository;

import java.util.List;
import java.util.UUID;

@Stub
public class OrderRepositoryStub implements OrderRepository {

    @Override
    public Order getOrder(Order.OrderVoId orderId) {
        return Order.builder()
                    .id(new Order.OrderVoId(UUID.fromString("f47e3f7e-7e3f-47e3-7e3f-47e37e3f47e3")))
                    .items(List.of(Item.builder()
                                       .name("Pizza")
                                       .price(10.90)
                                       .preparationTimeInMinutes(20)
                                       .build()
                        )
                    )
                    .status(EnumStatusOrder.READY_TO_COLLECT)
                    .build();
    }



    @Override
    public List<Order> getOrders() {
        return List.of(Order.builder()
                            .id(new Order.OrderVoId(UUID.fromString("f47e3f7e-7e3f-47e3-7e3f-47e37e3f47e3")))
                            .items(List.of(Item.builder()
                                               .id(new Item.ItemVoId(UUID.fromString("f47e3f7e-7e3f-47e3-7e3f-000000000000")))
                                               .name("Pizza")
                                               .price(10.90)
                                               .preparationTimeInMinutes(20)
                                               .build()
                                )
                            )
                            .status(EnumStatusOrder.READY_TO_COLLECT)
                            .build()
        );
    }
}
