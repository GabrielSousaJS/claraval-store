package com.gabrielsantos.backend.services;

import com.gabrielsantos.backend.dto.OrderItemDTO;
import com.gabrielsantos.backend.entities.OrderItem;
import com.gabrielsantos.backend.entities.pk.OrderItemPk;
import com.gabrielsantos.backend.services.exceptions.DatabaseException;
import com.gabrielsantos.backend.repositories.OrderItemRepository;
import com.gabrielsantos.backend.repositories.OrderRepository;
import com.gabrielsantos.backend.repositories.ProductRepository;
import com.gabrielsantos.backend.services.exceptions.QuantityException;
import com.gabrielsantos.backend.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository repository;

    @Autowired
    private OrderRepository orderDAO;

    @Autowired
    private ProductRepository productDAO;

    @Transactional
    public OrderItem saveItem(Long orderId, OrderItemDTO dto) {
        OrderItem entity = new OrderItem();
        dto.setOrderId(orderId);
        copyDtoToEntity(entity, dto);
        entity = repository.save(entity);
        return entity;
    }

    private void copyDtoToEntity(OrderItem entity, OrderItemDTO dto) {
        entity.setOrder(orderDAO.getReferenceById(dto.getOrderId()));
        entity.setProduct(productDAO.getReferenceById(dto.getProduct().getId()));
        entity.setQuantity(dto.getQuantity());
        entity.setPrice(entity.getPrice());
    }

    @Transactional
    public void update(Long orderId, Long productId, Integer quantity) {
        try {
            OrderItemPk key = instancePrimaryKey(orderId, productId);

            OrderItem entity = repository.getReferenceById(key);

            if (checkItemQuantity(entity, quantity)) {
                entity.setQuantity(quantity);
                repository.save(entity);
            }
        } catch (JpaObjectRetrievalFailureException e) {
            throw new ResourceNotFoundException("Item não encontrado");
        }
    }

    private OrderItemPk instancePrimaryKey(Long orderId, Long productId) {
        OrderItemPk key = new OrderItemPk();
        key.setOrder(orderDAO.getReferenceById(orderId));
        key.setProduct(productDAO.getReferenceById(productId));
        return key;
    }

    protected void delete(Long orderId, Long productId) {
        try {
            OrderItemPk key = instancePrimaryKey(orderId, productId);
            repository.deleteById(key);
        } catch (EmptyResultDataAccessException | JpaObjectRetrievalFailureException e) {
            throw new ResourceNotFoundException("Item não encontrado");
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Não é possível deletar o item");
        }
    }

    private boolean checkItemQuantity(OrderItem entity, Integer quantity) {
        if (entity.getProduct().getQuantity() >= quantity && quantity > 0)
            return true;
        throw new QuantityException("A quantidade de itens está incorreta, verifique o valor e tente novamente");
    }
}
