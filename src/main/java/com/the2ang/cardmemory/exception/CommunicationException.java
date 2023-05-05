package com.the2ang.cardmemory.exception;

public class CommunicationException extends RuntimeException {
    public CommunicationException() {
        super();
    }

    public CommunicationException(String message) {
        super(message);
    }

    public CommunicationException(String message, Throwable cause) {
        super(message, cause);
    }
}