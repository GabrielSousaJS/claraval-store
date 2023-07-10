package com.gabrielsantos.backend.controllers;


import com.gabrielsantos.backend.dto.OrderItemDTO;
import com.gabrielsantos.backend.dto.OrderWithPaymentDTO;
import com.gabrielsantos.backend.dto.OrderWithoutPaymentDTO;
import com.gabrielsantos.backend.dto.PaymentDTO;
import com.gabrielsantos.backend.services.OrderService;
import com.gabrielsantos.backend.services.RegistryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/orders")
public class OrderController {

    @Autowired
    private OrderService service;

    @Autowired
    private RegistryService registryService;

    @GetMapping(value = "/all-orders")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<OrderWithPaymentDTO>> findAll() {
        List<OrderWithPaymentDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping
    public ResponseEntity<List<OrderWithoutPaymentDTO>> findAllByClientId() {
        List<OrderWithoutPaymentDTO> list = service.findAllByClientId();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<OrderWithoutPaymentDTO> saveOrder(@RequestBody OrderWithoutPaymentDTO dto) {
        dto = service.saveOrder(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(dto.getId()).toUri();
        registryService.registryAction("Salvar pedido", "POST");
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}/payment")
    public ResponseEntity<OrderWithPaymentDTO> addPayment(@PathVariable Long id, @RequestBody PaymentDTO dto) {
        OrderWithPaymentDTO orderDTO = service.addPayment(id, dto);
        registryService.registryAction("Adicionar pagamento", "PUT");
        return ResponseEntity.ok().body(orderDTO);
    }

    @PutMapping(value = "/{id}/status")
    public ResponseEntity<OrderWithPaymentDTO> updateOrderStatus(
            @PathVariable Long id,
            @RequestParam(value = "orderStatus", defaultValue = "") String orderStatus
    ) {
        OrderWithPaymentDTO dto = service.updateOrderStatus(id, orderStatus);
        registryService.registryAction("Atualizar status", "PUT");
        return ResponseEntity.ok().body(dto);
    }

    @PutMapping(value = "/{id}/update-item")
    public ResponseEntity<OrderWithoutPaymentDTO> updateItem(
            @PathVariable Long id,
            @RequestParam(value = "productId", defaultValue = "") Long productId,
            @RequestParam(value = "quantity", defaultValue = "") Integer quantity
    ) {
        OrderWithoutPaymentDTO dto = service.updateItem(id, productId, quantity);
        registryService.registryAction("Atualizar item do pedido", "PUT");
        return ResponseEntity.ok().body(dto);
    }

    @PutMapping(value = "/{id}/add-item")
    public ResponseEntity<OrderWithoutPaymentDTO> addItemToOrder(
            @PathVariable Long id,
            @RequestBody OrderItemDTO dto
    ) {
        OrderWithoutPaymentDTO orderDTO = service.addItemToOrder(id, dto);
        registryService.registryAction("Adicionar item ao pedido", "PUT");
        return ResponseEntity.ok().body(orderDTO);
    }

    @DeleteMapping(value = "/delete-item")
    public ResponseEntity<Void> deleteItem(
            @RequestParam(value = "orderId", defaultValue = "") Long orderId,
            @RequestParam(value = "productId", defaultValue = "") Long productId
    ) {
        service.deleteItem(orderId, productId);
        registryService.registryAction("Apagar item do pedido", "DELETE");
        return ResponseEntity.noContent().build();
    }

}