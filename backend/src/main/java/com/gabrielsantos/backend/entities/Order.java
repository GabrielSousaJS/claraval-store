package com.gabrielsantos.backend.entities;

import com.gabrielsantos.backend.entities.enums.converters.OrderStatusConverter;
import com.gabrielsantos.backend.entities.enums.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    @Getter
    @Setter
    private Instant moment;
    @Getter
    @Setter
    @Convert(converter = OrderStatusConverter.class)
    private OrderStatus orderStatus;

    @ManyToOne
    @JoinColumn(name = "client_id")
    @Getter
    @Setter
    private User client;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "payment_id")
    @Getter
    @Setter
    private Payment payment;

    @OneToMany(mappedBy = "id.order")
    @Getter
    private Set<OrderItem> items = new HashSet<>();

    public Double getTotal() {
        Double sum = 0.0;
        for (OrderItem purchases : items) {
            sum += purchases.getSubTotal();
        }

        return sum;
    }

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant updatedAt;

    public Order() {
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = Instant.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}