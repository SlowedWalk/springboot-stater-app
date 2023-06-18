package tech.hidetora.security.enumeration;

import org.springframework.http.HttpStatus;

public enum ErrorCodes {
    APP_USER_NOT_FOUND(HttpStatus.NOT_FOUND.value()),
    APP_USER_ALREADY_EXISTS(HttpStatus.CONFLICT.value()),
    USER_HAS_NO_ROLES(2400);

    private int code;
    ErrorCodes(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
