package com.gabrielsantos.backend.services.exceptions;

import java.io.Serial;

public class QuantityException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public QuantityException(String msg) {
        super(msg);
    }
}
