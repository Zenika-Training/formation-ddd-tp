package com.zenika.ddd.mvc.order;

import com.zenika.ddd.aggregateorder.Order;
import com.zenika.ddd.mvc.order.adapter.OrderDtoMapper;
import com.zenika.ddd.mvc.order.dto.OrderDto;
import com.zenika.ddd.aggregateorder.GetOrderDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GetOrderApplicationService {

    private final GetOrderDomainService getOrderDomainService;

    private final OrderDtoMapper orderDtoMapper;



    public List<OrderDto> getOrders() {
        List<OrderDto> results = new ArrayList<>();

        List<Order> orders = getOrderDomainService.getOrders();

        if (!orders.isEmpty()) {
            results = List.of(orderDtoMapper.mapOrderToDto(orders.get(0)));
        }
        return results;
    }
}
