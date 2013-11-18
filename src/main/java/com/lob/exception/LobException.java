package com.lob.exception;

public abstract class LobException extends Exception {

	public LobException(String message) {
		super(message, null);
	}

	public LobException(String message, Throwable e) {
		super(message, e);
	}

	private static final long serialVersionUID = 1L;

}
