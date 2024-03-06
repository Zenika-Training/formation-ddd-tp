package com.zenika.ddd.mvc.order;

import com.zenika.ddd.mvc.order.adapter.OrderDtoMapper;
import com.zenika.ddd.mvc.order.dto.OrderDto;
import com.zenika.ddd.aggregateorder.GetOrderDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetOrderApplicationService {

    private final GetOrderDomainService getOrderDomainService;
    private final OrderDtoMapper orderDtoMapper;

    public List<OrderDto> getOrders() {
        return List.of(orderDtoMapper.mapOrderToDto(getOrderDomainService.getOrders().get(0)));
    }
}
