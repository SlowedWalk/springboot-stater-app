package tech.hidetora.security.exception;


import lombok.Getter;
import tech.hidetora.security.enumeration.ErrorCodes;

public class AppUserException extends RuntimeException {
    @Getter
    private ErrorCodes errorCode;
    public AppUserException(String message) {
        super(message);
    }

    public AppUserException(String message, Throwable cause) {
        super(message, cause);
    }

    public AppUserException(String message, Throwable cause, ErrorCodes errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public AppUserException(String message, ErrorCodes errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}

