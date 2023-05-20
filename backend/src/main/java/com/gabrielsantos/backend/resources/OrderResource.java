package com.gabrielsantos.backend.resources;

import com.gabrielsantos.backend.dto.OrderWithPaymentDTO;
import com.gabrielsantos.backend.dto.OrderWithoutPaymentDTO;
import com.gabrielsantos.backend.dto.PaymentDTO;
import com.gabrielsantos.backend.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/api/orders")
public class OrderResource {

    @Autowired
    private OrderService service;

    @PostMapping
    public ResponseEntity<OrderWithoutPaymentDTO> saveOrder(@RequestBody OrderWithoutPaymentDTO dto) {
        dto = service.saveOrder(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}/payment")
    public ResponseEntity<OrderWithPaymentDTO> addPayment(@PathVariable Long id, @RequestBody PaymentDTO dto) {
        OrderWithPaymentDTO orderDTO = service.addPayment(id, dto);
        return ResponseEntity.ok().body(orderDTO);
    }
}
