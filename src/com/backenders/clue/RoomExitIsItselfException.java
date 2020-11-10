package com.backenders.clue;

public class RoomExitIsItselfException extends RuntimeException {
    public RoomExitIsItselfException() {
    }

    public RoomExitIsItselfException(String message) {
        super(message);
    }

    public RoomExitIsItselfException(String message, Throwable cause) {
        super(message, cause);
    }

    public RoomExitIsItselfException(Throwable cause) {
        super(cause);
    }

    public RoomExitIsItselfException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
