package com.gabrielsantos.backend.resources.exceptions;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {

    @Getter
    private List<FieldMessage> errors = new ArrayList<>();

    public void addError(String fieldError, String message) {
        errors.add(new FieldMessage(fieldError, message));
    }
}