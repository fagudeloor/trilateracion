package com.challenge.meli.trilateracion.api.services.exception;

public class IncompleteMessageException extends RuntimeException {

    public IncompleteMessageException() {
        }

    public IncompleteMessageException(String message) {
            super(message);
        }

    public IncompleteMessageException(String message, Throwable cause) {
            super(message, cause);
        }

    public IncompleteMessageException(Throwable cause) {
            super(cause);
        }

    public IncompleteMessageException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
            super(message, cause, enableSuppression, writableStackTrace);
        }
}
