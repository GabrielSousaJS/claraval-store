package com.gabrielsantos.backend.resources;

import com.gabrielsantos.backend.dto.OrderWithoutPayment;
import com.gabrielsantos.backend.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/orders")
public class OrderResource {

    @Autowired
    private OrderService service;

    @PostMapping
    public ResponseEntity<OrderWithoutPayment> saveOrder(@RequestBody OrderWithoutPayment dto) {
        dto = service.saveOrder(dto);
        return ResponseEntity.ok().body(dto);
    }

}
