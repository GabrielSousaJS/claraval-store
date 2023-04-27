package com.gabrielsantos.backend.entities.enums.converters;

import com.gabrielsantos.backend.entities.enums.PaymentMethod;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class PaymentMethodConverter implements AttributeConverter<PaymentMethod, String> {

    @Override
    public String convertToDatabaseColumn(PaymentMethod paymentMethod) {
        if (paymentMethod == null) {
            return null;
        }

        return paymentMethod.getValue();
    }

    @Override
    public PaymentMethod convertToEntityAttribute(String value) {
        if (value == null) {
            return null;
        }

        return Stream.of(PaymentMethod.values())
                .filter(payment -> payment.getValue().equals(value))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
