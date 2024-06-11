package com.zenika.ddd.mvc;

import com.zenika.ddd.mvc.dto.OrderDto;
import com.zenika.ddd.service.CreateOrderApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class CreateOrderController {

    private final CreateOrderApplicationService createOrderApplicationService;

    @PostMapping("/create")
    public OrderDto createOrder(@RequestBody OrderDto orderDto) {
        return createOrderApplicationService.createOrder(orderDto);
    }
}
