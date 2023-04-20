package com.gabrielsantos.backend.resources.exceptions;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

public class StandardError implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private Instant timestamp;
    @Getter @Setter
    private Integer status;
    @Getter @Setter
    private String error;
    @Getter @Setter
    private String path;

    public StandardError() {
    }

    public StandardError(Instant timestamp, Integer status, String error, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.path = path;
    }
}
