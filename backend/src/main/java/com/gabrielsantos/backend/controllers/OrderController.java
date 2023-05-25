package com.gabrielsantos.backend.controllers;

import com.gabrielsantos.backend.dto.OrderItemDTO;
import com.gabrielsantos.backend.dto.OrderWithPaymentDTO;
import com.gabrielsantos.backend.dto.OrderWithoutPaymentDTO;
import com.gabrielsantos.backend.dto.PaymentDTO;
import com.gabrielsantos.backend.services.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/orders")
@Api(tags = "Order Resource", value = "OrderResource")
public class OrderController {

    @Autowired
    private OrderService service;

    @GetMapping
    @ApiOperation(value = "Get orders by client")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Orders found"),
            @ApiResponse(code = 401, message = "Unathorized feature")
    })
    public ResponseEntity<List<OrderWithoutPaymentDTO>> findAllByClientId() {
        List<OrderWithoutPaymentDTO> list = service.findAllByClientId();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    @ApiOperation(value = "Place new order")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Order saved"),
            @ApiResponse(code = 401, message = "Unathorized feature"),
            @ApiResponse(code = 403, message = "Prohibited resource")
    })
    public ResponseEntity<OrderWithoutPaymentDTO> saveOrder(@RequestBody OrderWithoutPaymentDTO dto) {
        dto = service.saveOrder(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}/payment")
    @ApiOperation(value = "Add payment to order")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Payment added"),
            @ApiResponse(code = 401, message = "Unathorized feature"),
            @ApiResponse(code = 404, message = "Order not found"),
            @ApiResponse(code = 406, message = "Incorrect properties")
    })
    public ResponseEntity<OrderWithPaymentDTO> addPayment(@PathVariable Long id, @RequestBody PaymentDTO dto) {
        OrderWithPaymentDTO orderDTO = service.addPayment(id, dto);
        return ResponseEntity.ok().body(orderDTO);
    }

    @PutMapping(value = "/{id}/status")
    @ApiOperation(value = "Update order status")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Order updated"),
            @ApiResponse(code = 401, message = "Unathorized feature"),
            @ApiResponse(code = 404, message = "Order not found")
    })
    public ResponseEntity<OrderWithPaymentDTO> updateOrderStatus(
            @PathVariable Long id,
            @RequestParam(value = "orderStatus", defaultValue = "") String orderStatus
    ) {
        OrderWithPaymentDTO dto = service.updateOrderStatus(id, orderStatus);
        return ResponseEntity.ok().body(dto);
    }

    @PutMapping(value = "/{id}/update-item")
    @ApiOperation(value = "Add item to order")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Item added"),
            @ApiResponse(code = 401, message = "Unathorized feature"),
            @ApiResponse(code = 403, message = "Prohibited resource"),
            @ApiResponse(code = 404, message = "Item not found"),
            @ApiResponse(code = 406, message = "Payment already made"),
            @ApiResponse(code = 412, message = "Quantity not available in stock")
    })
    public ResponseEntity<OrderWithoutPaymentDTO> updateItem(
            @PathVariable Long id,
            @RequestParam(value = "productId", defaultValue = "") Long productId,
            @RequestParam(value = "quantity", defaultValue = "") Integer quantity
    ) {
        OrderWithoutPaymentDTO dto = service.updateItem(id, productId, quantity);
        return ResponseEntity.ok().body(dto);
    }

    @PutMapping(value = "/{id}/add-item")
    @ApiOperation(value = "Add item to order")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Item added"),
            @ApiResponse(code = 401, message = "Unathorized feature"),
            @ApiResponse(code = 403, message = "Prohibited resource"),
            @ApiResponse(code = 404, message = "Item not found")
    })
    public ResponseEntity<OrderWithoutPaymentDTO> addItemToOrder(
            @PathVariable Long id,
            @RequestBody OrderItemDTO dto
    ) {
        OrderWithoutPaymentDTO orderDTO = service.addItemToOrder(id, dto);
        return ResponseEntity.ok().body(orderDTO);
    }

    @DeleteMapping(value = "/delete-item")
    @ApiOperation(value = "Delete item to order")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Deleted item"),
            @ApiResponse(code = 401, message = "Unathorized feature"),
            @ApiResponse(code = 403, message = "Prohibited resource"),
            @ApiResponse(code = 404, message = "Item not found"),
            @ApiResponse(code = 500, message = "Integraty violation")
    })
    public ResponseEntity<Void> deleteItem(
            @RequestParam(value = "orderId", defaultValue = "") Long orderId,
            @RequestParam(value = "productId", defaultValue = "") Long productId
    ) {
        service.deleteItem(orderId, productId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "Delete order")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Deleted order"),
            @ApiResponse(code = 401, message = "Unathorized feature"),
            @ApiResponse(code = 403, message = "Prohibited resource"),
            @ApiResponse(code = 404, message = "Order not found"),
            @ApiResponse(code = 500, message = "Integraty violation")
    })
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
