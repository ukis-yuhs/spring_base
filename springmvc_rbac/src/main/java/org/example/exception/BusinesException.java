package org.example.exception;

public class BusinesException extends RuntimeException {

    public BusinesException() {
        super();
    }

    public BusinesException(String message) {
        super(message);
    }

    public BusinesException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinesException(Throwable cause) {
        super(cause);
    }

    protected BusinesException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
