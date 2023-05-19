package com.gabrielsantos.backend.services;

import com.gabrielsantos.backend.dto.OrderItemDTO;
import com.gabrielsantos.backend.entities.OrderItem;
import com.gabrielsantos.backend.entities.pk.OrderItemPk;
import com.gabrielsantos.backend.repositories.OrderItemRepository;
import com.gabrielsantos.backend.repositories.OrderRepository;
import com.gabrielsantos.backend.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository repository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public List<OrderItemDTO> findAllItemsOfOrder(Long orderId) {
        List<OrderItem> list = repository.findAllItemsOfOrder(orderId);
        return list.stream().map(OrderItemDTO::new).toList();
    }

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
    public OrderItemDTO update(OrderItemDTO dto) {
        OrderItemPk key = new OrderItemPk();
        key.setOrder(orderRepository.getReferenceById(dto.getOrderId()));
        key.setProduct(productRepository.getReferenceById(dto.getProduct().getId()));

        OrderItem entity = repository.getReferenceById(key);
        entity.setQuantity(dto.getQuantity());
        entity = repository.save(entity);
        return new OrderItemDTO(entity);
    }
}
