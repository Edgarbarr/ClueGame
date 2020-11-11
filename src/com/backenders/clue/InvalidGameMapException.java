package com.backenders.clue;

public class InvalidGameMapException extends RuntimeException {
    public InvalidGameMapException() {
    }

    public InvalidGameMapException(String message) {
        super(message);
    }

    public InvalidGameMapException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidGameMapException(Throwable cause) {
        super(cause);
    }

    public InvalidGameMapException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
