package com.gabrielsantos.backend.entities.enums;

public enum PaymentMethod {

    PIX(1),
    CARD(2),
    BANK_SLIP(3);

    private int code;

    PaymentMethod(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
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
