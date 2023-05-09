package com.gabrielsantos.backend.services;

import com.gabrielsantos.backend.dto.OrderItemDTO;
import com.gabrielsantos.backend.entities.OrderItem;
import com.gabrielsantos.backend.repositories.OrderItemRepository;
import com.gabrielsantos.backend.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository repository;

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public OrderItem saveItem(OrderItemDTO dto) {
        OrderItem entity = new OrderItem();
        copyDtoToEntity(entity, dto);
        entity = repository.save(entity);
        return entity;
    }

    private void copyDtoToEntity(OrderItem entity, OrderItemDTO dto) {
        entity.setProduct(productRepository.getReferenceById(dto.getProduct().getId()));
        entity.setQuantity(dto.getQuantity());
        entity.setPrice(dto.getPrice());
    }
}
