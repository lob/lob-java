package com.lob.exception;

public class ParsingException extends LobException {

    private static final long serialVersionUID = 1L;

    public ParsingException(Exception e) {
        super(e.getMessage(), 0, e);
    }
}
