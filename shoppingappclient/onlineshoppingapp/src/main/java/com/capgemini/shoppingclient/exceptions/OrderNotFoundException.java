package com.capgemini.shoppingclient.exceptions;

@SuppressWarnings("serial")
public class OrderNotFoundException extends RuntimeException{
	public OrderNotFoundException(String message) {
		super(message);
	}

}
