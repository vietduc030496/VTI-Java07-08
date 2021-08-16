package com.vti.spring1.exception;

public class ShoppingException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 8847445982730593432L;

	public ShoppingException(String exception) {
        super(exception);
    }
}
