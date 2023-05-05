package com.the2ang.cardmemory.exception;

public class EntityExistException extends RuntimeException {
    public EntityExistException() {
        super();
    }

    public EntityExistException(String message) {
        super(message);
    }

    public EntityExistException(String message, Throwable cause) {
        super(message, cause);
    }
}
