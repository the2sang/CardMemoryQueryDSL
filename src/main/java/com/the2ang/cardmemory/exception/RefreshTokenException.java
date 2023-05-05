package com.the2ang.cardmemory.exception;

public class RefreshTokenException extends RuntimeException {
    public RefreshTokenException() {
        super();
    }

    public RefreshTokenException(String message) {
        super(message);
    }

    public RefreshTokenException(String message, Throwable cause) {
        super(message, cause);
    }
}
