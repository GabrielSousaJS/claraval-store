package com.gabrielsantos.backend.entities.enums;

import lombok.Getter;

public enum PaymentMethod {

    PIX("PIX"),
    CARD("Card"),
    BANK_SLIP("Bank slip");

    @Getter
    private String value;

    PaymentMethod(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
