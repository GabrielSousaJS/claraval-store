package com.gabrielsantos.backend.entities.enums;

import lombok.Getter;

public enum OrderStatus {

    WAITING_PAYMENT("Waiting payment"),
    PAID("Paid"),
    SHIPPED("Shipped"),
    DELIVERED("Delivered");

    @Getter
    private String value;

    private OrderStatus(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
