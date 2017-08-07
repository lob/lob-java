package com.lob.exception;

public class AuthenticationException extends LobException {

    public AuthenticationException(String message, Integer statusCode) {
        super(message, statusCode);
    }

    private static final long serialVersionUID = 1L;

}
