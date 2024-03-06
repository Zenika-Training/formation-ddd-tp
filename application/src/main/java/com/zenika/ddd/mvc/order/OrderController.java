package com.zenika.ddd.mvc.order;

import com.zenika.ddd.mvc.order.dto.OrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class OrderController {

    private final GetOrderApplicationService orderApplicationService;


    @GetMapping("/order")
    public ResponseEntity<List<OrderDto>> getOrders() {
        return ResponseEntity.of(Optional.ofNullable(orderApplicationService.getOrders()));
    }

}
