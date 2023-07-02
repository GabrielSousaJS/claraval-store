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
import com.gabrielsantos.backend.services.exceptions.DatabaseException;
import com.gabrielsantos.backend.services.exceptions.ForbiddenException;
import com.gabrielsantos.backend.services.exceptions.PaymentMadeException;
import com.gabrielsantos.backend.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Autowired
    private OrderItemService orderItemService;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private ProductService productService;

    @Autowired
    private AuthService authService;

    @Transactional(readOnly = true)
    public List<OrderWithoutPaymentDTO> findAllByClientId() {
        User client = authService.authenticated();
        List<Order> list = repository.findAllByClientId(client.getId());
        return list.stream().map(order -> new OrderWithoutPaymentDTO(order, order.getItems())).toList();
    }

    @Transactional
    public OrderWithoutPaymentDTO saveOrder(OrderWithoutPaymentDTO dto) {
        Order entity = new Order();
        entity.setClient(checkLoggedUser(dto.getClientId()));
        copyDtoToEntity(entity, dto);
        entity = repository.save(entity);

        Order finalEntity = entity;
        addItems(finalEntity, dto);
        finalEntity = repository.save(finalEntity);
        return new OrderWithoutPaymentDTO(finalEntity, finalEntity.getItems());
    }

    @Transactional
    public OrderWithPaymentDTO addPayment(Long id, PaymentDTO dto) {
        try {
            Order entity = repository.getReferenceById(id);

            if (paymentNotMade(entity)) {
                entity.setPayment(paymentService.savePayment(dto));
                entity.setOrderStatus(OrderStatus.PAID);
                entity = repository.save(entity);
                productService.updateQuantity(entity.getItems());
                return new OrderWithPaymentDTO(entity, entity.getItems());
            } else {
                throw new PaymentMadeException("O pagamento da encomenda já foi efetuado");
            }
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Pedido não encontrado");
        }
    }

    @Transactional
    public OrderWithPaymentDTO updateOrderStatus(Long id, String orderStatus) {
        try {
            Order entity = repository.getReferenceById(id);
            entity.setOrderStatus(OrderStatus.valueOf(orderStatus));
            repository.save(entity);
            return new OrderWithPaymentDTO(entity, entity.getItems());
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Pedido não encontrado");
        }
    }

    @Transactional
    public OrderWithoutPaymentDTO updateItem(Long orderId, Long productId, Integer quantity) {
        try {
            Order entity = repository.getReferenceById(orderId);

            if (paymentNotMade(entity))
                orderItemService.update(orderId, productId, quantity);
            else
                throw new PaymentMadeException("O pagamento já foi efeutado, não é possível alterar a " +
                        "quantidade dos itens");

            return new OrderWithoutPaymentDTO(entity, entity.getItems());
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Pedido não encontrado");
        }
    }

    @Transactional
    public OrderWithoutPaymentDTO addItemToOrder(Long orderId, OrderItemDTO dto) {
        try {
            Order entity = repository.getReferenceById(orderId);

            if (paymentNotMade(entity)) {
                OrderItem item = orderItemService.saveItem(orderId, dto);
                entity.getItems().add(item);
                repository.save(entity);
                return new OrderWithoutPaymentDTO(entity, entity.getItems());
            } else {
                throw new PaymentMadeException("O pagamento já foi feito, não é possível adicionar novos itens");
            }
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Item não encontrado");
        }
    }

    @Transactional
    public void deleteItem(Long orderId, Long productId) {
        orderItemService.delete(orderId, productId);
    }

    public void deleteById(Long orderId) {
        try {
            repository.deleteById(orderId);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Pedido não encontrado");
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Não é possível deletar o pedido, pois ainda existem itens");
        }
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

    private User checkLoggedUser(Long userId) {
        User loggedUser = authService.authenticated();

        if (loggedUser.getId().equals(userId))
            return loggedUser;
        else
            throw new ForbiddenException("O usuário que está fazendo a solicitação não é o mesmo que está logado");
    }

    private boolean paymentNotMade(Order entity) {
        return entity.getOrderStatus() == OrderStatus.WAITING_PAYMENT;
    }
}