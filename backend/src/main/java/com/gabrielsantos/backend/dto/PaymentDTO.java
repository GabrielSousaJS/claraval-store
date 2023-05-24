package com.gabrielsantos.backend.dto;

import com.gabrielsantos.backend.entities.Payment;
import com.gabrielsantos.backend.entities.enums.PaymentMethod;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

public class PaymentDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private Long id;
    @Getter @Setter
    private Instant moment;
    @Getter @Setter
    private PaymentMethod paymentMethod;

    public PaymentDTO() {
    }

    public PaymentDTO(Payment entity) {
        id = entity.getId();
        moment = entity.getMoment();
        paymentMethod = entity.getPaymentMethod();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentDTO that = (PaymentDTO) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
