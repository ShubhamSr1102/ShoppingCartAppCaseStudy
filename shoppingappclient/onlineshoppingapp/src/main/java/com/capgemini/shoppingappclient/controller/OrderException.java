package com.capgemini.shoppingappclient.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.capgemini.shoppingapp.exceptions.OrderNotFoundException;
import com.capgemini.shoppingappclient.entity.Order;

@ControllerAdvice
public class OrderException {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrderException.class);
		
		@ExceptionHandler(value = OrderNotFoundException.class)
		public ResponseEntity<Order> orderNotFoundException(OrderNotFoundException exception) {
			//System.out.println(exception);
			//System.out.println(exception.getCause());
			LOGGER.info("Order does not exist");
			LOGGER.error("Order does not exist", exception);
			return new ResponseEntity<Order>(HttpStatus.NOT_FOUND);
		}

}
