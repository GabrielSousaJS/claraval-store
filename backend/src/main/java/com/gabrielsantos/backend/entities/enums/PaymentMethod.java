package com.gabrielsantos.backend.entities.enums;

import lombok.Getter;

public enum PaymentMethod {

    PIX(1),
    CARD(2),
    BANK_SLIP(3);

    @Getter
    private int code;

    PaymentMethod(int code) {
        this.code = code;
    }

    public static PaymentMethod valueOf(int code) {
        for (PaymentMethod value : PaymentMethod.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid Payment Method code!");
    }
}
