package com.gabrielsantos.backend.resources.exceptions;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

public class FieldMessage implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String fieldError;
    @Getter @Setter
    private String message;

    public FieldMessage() {
    }

    public FieldMessage(String fieldError, String message) {
        this.fieldError = fieldError;
        this.message = message;
    }
}
