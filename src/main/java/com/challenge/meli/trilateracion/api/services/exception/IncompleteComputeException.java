package com.challenge.meli.trilateracion.api.services.exception;

public class IncompleteComputeException extends RuntimeException {

    public IncompleteComputeException() {
    }

    public IncompleteComputeException(String message) {
        super(message);
    }

    public IncompleteComputeException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncompleteComputeException(Throwable cause) {
        super(cause);
    }

    public IncompleteComputeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
