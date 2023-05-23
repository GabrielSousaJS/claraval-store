package com.gabrielsantos.backend.services;

import com.gabrielsantos.backend.dto.OrderItemDTO;
import com.gabrielsantos.backend.entities.OrderItem;
import com.gabrielsantos.backend.entities.pk.OrderItemPk;
import com.gabrielsantos.backend.repositories.OrderItemRepository;
import com.gabrielsantos.backend.repositories.OrderRepository;
import com.gabrielsantos.backend.repositories.ProductRepository;
import com.gabrielsantos.backend.services.exceptions.QuantityException;
import com.gabrielsantos.backend.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository repository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public OrderItem saveItem(Long orderId, OrderItemDTO dto) {
        OrderItem entity = new OrderItem();
        dto.setOrderId(orderId);
        copyDtoToEntity(entity, dto);
        entity = repository.save(entity);
        return entity;
    }

    private void copyDtoToEntity(OrderItem entity, OrderItemDTO dto) {
        entity.setOrder(orderRepository.getReferenceById(dto.getOrderId()));
        entity.setProduct(productRepository.getReferenceById(dto.getProduct().getId()));
        entity.setQuantity(dto.getQuantity());
        entity.setPrice(entity.getPrice());
    }

    @Transactional
    public void update(Long orderId, Long productId, Integer quantity) {
        OrderItemPk key = new OrderItemPk();
        key.setOrder(orderRepository.getReferenceById(orderId));
        key.setProduct(productRepository.getReferenceById(productId));

        OrderItem entity = repository.getReferenceById(key);

        if (!checkItemQuantity(entity, quantity))
            throw new QuantityException("The quantity of items is incorrect, check the value and try again");

        entity.setQuantity(quantity);
        repository.save(entity);
    }

    private boolean checkItemQuantity(OrderItem entity, Integer quantity) {
        return entity.getProduct().getQuantity() >= quantity && quantity > 0;
    }
}
