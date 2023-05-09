package com.gabrielsantos.backend.services;

import com.gabrielsantos.backend.dto.OrderDTO;
import com.gabrielsantos.backend.dto.OrderItemDTO;
import com.gabrielsantos.backend.dto.PaymentDTO;
import com.gabrielsantos.backend.entities.Order;
import com.gabrielsantos.backend.entities.OrderItem;
import com.gabrielsantos.backend.entities.enums.OrderStatus;
import com.gabrielsantos.backend.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Autowired
    private OrderItemService orderItemService;

    @Autowired
    private PaymentService paymentService;

    @Transactional
    public OrderDTO saveOrder(OrderDTO dto) {
        Order entity = new Order();
        copyDtoToEntity(entity, dto);
        entity = repository.save(entity);
        return new OrderDTO(entity);
    }

    @Transactional
    public OrderDTO addPayment(Long id, PaymentDTO dto) {
        Order entity = repository.getReferenceById(id);
        entity.setPayment(paymentService.savePayment(dto));
        repository.save(entity);
        return new OrderDTO(entity);
    }

    @Transactional
    public OrderDTO updateOrderStatus(Long id, String orderStatus) {
        Order entity = repository.getReferenceById(id);
        entity.setOrderStatus(OrderStatus.valueOf(orderStatus));
        repository.save(entity);
        return new OrderDTO(entity);
    }

    private void copyDtoToEntity(Order entity, OrderDTO dto) {
        entity.setMoment(dto.getMoment());
        entity.setOrderStatus(dto.getOrderStatus());

        entity.getItems().clear();

        for (OrderItemDTO item : dto.getItems()) {
            OrderItem orderItem = orderItemService.saveItem(item);
            entity.getItems().add(orderItem);
        }
    }
}
