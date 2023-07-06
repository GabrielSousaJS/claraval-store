package com.gabrielsantos.backend.controllers;

import com.gabrielsantos.backend.dto.OrderItemDTO;
import com.gabrielsantos.backend.dto.OrderWithPaymentDTO;
import com.gabrielsantos.backend.dto.OrderWithoutPaymentDTO;
import com.gabrielsantos.backend.dto.PaymentDTO;
import com.gabrielsantos.backend.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/orders")
public class OrderController {

    @Autowired
    private OrderService service;

    @GetMapping
    public ResponseEntity<List<OrderWithoutPaymentDTO>> findAllByClientId() {
        List<OrderWithoutPaymentDTO> list = service.findAllByClientId();
        return ResponseEntity.ok().body(list);
    }

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

    @PutMapping(value = "/{id}/status")
    public ResponseEntity<OrderWithPaymentDTO> updateOrderStatus(
            @PathVariable Long id,
            @RequestParam(value = "orderStatus", defaultValue = "") String orderStatus
    ) {
        OrderWithPaymentDTO dto = service.updateOrderStatus(id, orderStatus);
        return ResponseEntity.ok().body(dto);
    }

    @PutMapping(value = "/{id}/update-item")
    public ResponseEntity<OrderWithoutPaymentDTO> updateItem(
            @PathVariable Long id,
            @RequestParam(value = "productId", defaultValue = "") Long productId,
            @RequestParam(value = "quantity", defaultValue = "") Integer quantity
    ) {
        OrderWithoutPaymentDTO dto = service.updateItem(id, productId, quantity);
        return ResponseEntity.ok().body(dto);
    }

    @PutMapping(value = "/{id}/add-item")
    public ResponseEntity<OrderWithoutPaymentDTO> addItemToOrder(
            @PathVariable Long id,
            @RequestBody OrderItemDTO dto
    ) {
        OrderWithoutPaymentDTO orderDTO = service.addItemToOrder(id, dto);
        return ResponseEntity.ok().body(orderDTO);
    }

    @DeleteMapping(value = "/delete-item")
    public ResponseEntity<Void> deleteItem(
            @RequestParam(value = "orderId", defaultValue = "") Long orderId,
            @RequestParam(value = "productId", defaultValue = "") Long productId
    ) {
        service.deleteItem(orderId, productId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
