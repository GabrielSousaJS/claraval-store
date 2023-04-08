package com.gabrielsantos.backend.services.exceptions;

import java.io.Serial;

public class DifferentSellerLoggedException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public DifferentSellerLoggedException(String msg) {
        super(msg);
    }
}
