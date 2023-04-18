package com.gabrielsantos.backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gabrielsantos.backend.entities.enums.PaymentMethod;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "payments")
public class Payment implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    @Getter @Setter
    private Instant moment;

    private Integer paymentMethod;

    @JsonIgnore
    @OneToOne
    @MapsId
    private Order order;

    public Payment() {
    }

    public Payment(Long id, Instant moment, PaymentMethod paymentMethod, Order order) {
        this.id = id;
        this.moment = moment;
        setPaymentMethod(paymentMethod);
        this.order = order;
    }

    public PaymentMethod getPaymentMethod() {
        return PaymentMethod.valueOf(paymentMethod);
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        if (paymentMethod != null) {
            this.paymentMethod = paymentMethod.getCode();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Objects.equals(id, payment.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
