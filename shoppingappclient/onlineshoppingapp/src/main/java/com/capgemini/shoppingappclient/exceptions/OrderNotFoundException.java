package com.capgemini.shoppingappclient.exceptions;

@SuppressWarnings("serial")
public class OrderNotFoundException extends RuntimeException{
	public OrderNotFoundException(String message) {
		super(message);
	}

}
