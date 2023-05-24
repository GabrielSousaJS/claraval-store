package com.gabrielsantos.backend.controllers.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.codehaus.jackson.annotate.JsonProperty;

import java.io.Serial;
import java.io.Serializable;

public class OAuthCustomError implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String error;

    @JsonProperty("error_description")
    @Getter @Setter
    private String errorDescription;

    public OAuthCustomError() {
    }

    public OAuthCustomError(String error, String errorDescription) {
        this.error = error;
        this.errorDescription = errorDescription;
    }
}
