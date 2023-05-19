package com.gabrielsantos.backend.services;

import com.gabrielsantos.backend.dto.OrderItemDTO;
import com.gabrielsantos.backend.dto.OrderWithPaymentDTO;
import com.gabrielsantos.backend.dto.OrderWithoutPaymentDTO;
import com.gabrielsantos.backend.dto.PaymentDTO;
import com.gabrielsantos.backend.entities.Order;
import com.gabrielsantos.backend.entities.OrderItem;
import com.gabrielsantos.backend.entities.User;
import com.gabrielsantos.backend.entities.enums.OrderStatus;
import com.gabrielsantos.backend.repositories.OrderRepository;
import com.gabrielsantos.backend.services.exceptions.ForbiddenException;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private AuthService authService;

    @Transactional
    public OrderWithoutPaymentDTO saveOrder(OrderWithoutPaymentDTO dto) {
        Order entity = new Order();
        entity.setClient(checkLoggedUser(dto));
        copyDtoToEntity(entity, dto);
        entity = repository.save(entity);

        Order finalEntity = entity;
        addItems(finalEntity, dto);
        finalEntity = repository.save(finalEntity);
        return new OrderWithoutPaymentDTO(finalEntity, finalEntity.getItems());
    }

    @Transactional
    public OrderWithPaymentDTO addPayment(Long id, PaymentDTO dto) {
        Order entity = repository.getReferenceById(id);
        entity.setClient(authService.authenticated());
        entity.setPayment(paymentService.savePayment(dto));
        repository.save(entity);
        return new OrderWithPaymentDTO(entity);
    }

    @Transactional
    public OrderWithoutPaymentDTO updateOrderStatus(Long id, String orderStatus) {
        Order entity = repository.getReferenceById(id);
        entity.setOrderStatus(OrderStatus.valueOf(orderStatus));
        repository.save(entity);
        return new OrderWithoutPaymentDTO(entity);
    }

    private void copyDtoToEntity(Order entity, OrderWithoutPaymentDTO dto) {
        entity.setMoment(dto.getMoment());
        entity.setOrderStatus(dto.getOrderStatus());
    }

    private void addItems(Order entity, OrderWithoutPaymentDTO dto) {
        entity.getItems().clear();

        for (OrderItemDTO item : dto.getItems()) {
            OrderItem orderItem = orderItemService.saveItem(entity.getId(), item);
            entity.getItems().add(orderItem);
        }
    }

    private User checkLoggedUser(OrderWithoutPaymentDTO dto) {
        User loggedUser = authService.authenticated();

        if (loggedUser.getId().equals(dto.getClientId()))
            return loggedUser;
        else
            throw new ForbiddenException("The user who is making the request is not the one who is logged in.");
    }
}
