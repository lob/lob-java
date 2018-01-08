package com.lob.exception;

public class AuthenticationException extends LobException {

    private static final long serialVersionUID = 1L;

    public AuthenticationException(String message, Integer statusCode) {
        super(message, statusCode);
    }

}
