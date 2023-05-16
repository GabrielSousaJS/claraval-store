package com.gabrielsantos.backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gabrielsantos.backend.entities.pk.OrderItemPk;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "order_item")
public class OrderItem implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private OrderItemPk id = new OrderItemPk();
    @Getter @Setter
    private Integer quantity;
    private Double price;

    public OrderItem() {
    }

    public OrderItem(Order order, Product product, Integer quantity, Double price) {
        id.setOrder(order);
        id.setProduct(product);
        this.quantity = quantity;
        this.price = price;
    }

    @JsonIgnore
    public Order getOrder() {
        return id.getOrder();
    }

    public void setOrder(Order order) {
        id.setOrder(order);
    }

    public Product getProduct() {
        return id.getProduct();
    }

    public void setProduct(Product product) {
        id.setProduct(product);
    }

    public Double getPrice() {
        return id.getProduct().getPrice();
    }

    public void setPrice(Double price) {
        this.price = id.getProduct().getPrice();
    }

    public Double getSubTotal() {
        return quantity * price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return Objects.equals(id, orderItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}