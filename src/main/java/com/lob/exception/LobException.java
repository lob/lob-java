package com.lob.exception;

public abstract class LobException extends Exception {

    private Integer statusCode;

    public LobException(String message, Integer statusCode) {
        super(message, null);
        this.statusCode = statusCode;
    }

    public LobException(String message, Integer statusCode, Throwable e) {
        super(message, e);
        this.statusCode = statusCode;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

}
