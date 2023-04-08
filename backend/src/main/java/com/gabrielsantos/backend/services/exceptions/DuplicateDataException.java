package com.gabrielsantos.backend.services.exceptions;

import java.io.Serial;

public class DuplicateDataException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public DuplicateDataException(String msg) {
        super(msg);
    }
}
