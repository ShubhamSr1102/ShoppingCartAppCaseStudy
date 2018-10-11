package com.capgemini.shoppingapp.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.shoppingapp.entity.LineItem;
import com.capgemini.shoppingapp.entity.Order;
import com.capgemini.shoppingapp.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	OrderService orderService;

	@PostMapping("/shop/cart")
	public ResponseEntity<LineItem> addLineItem(@RequestBody LineItem item, int customerId) {
		orderService.addLineItem(item, customerId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/shop/cart")
	public ResponseEntity<Set<LineItem>> getLineItems(int customerId) {
		Set<LineItem> tempSet = orderService.getLineItems(customerId);
		return new ResponseEntity<Set<LineItem>>(tempSet, HttpStatus.OK);
	}

	@DeleteMapping("/shop/cart")
	public ResponseEntity<Set<LineItem>> removeLineItem(int customerId, @RequestBody LineItem item) {
		orderService.removeLineItem(item, customerId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("/shop/order")
	public ResponseEntity<Order> submitOrder(@RequestBody Order order) {
		return new ResponseEntity<Order>(orderService.submitOrder(order), HttpStatus.OK);

	}

	@PutMapping("/shop/order/{orderId}")
	public ResponseEntity<Order> cancelOrder(@PathVariable int orderId, String cancel) {
		return new ResponseEntity<Order>(orderService.cancelOrder(orderId), HttpStatus.OK);
	}

	@DeleteMapping("/shop/order/{orderId}")
	public ResponseEntity<Order> deleteOrder(@PathVariable int orderId) {
		orderService.deleteOrder(orderId);
		return new ResponseEntity<Order>(HttpStatus.OK);
	}

	@GetMapping("/shop/order")
	public ResponseEntity<Order> getOrder(@RequestParam int orderId) {
		return new ResponseEntity<Order>(orderService.getOrder(orderId), HttpStatus.OK);
	}
	
	@GetMapping("/shop/orders")
	public ResponseEntity<List<Order>> getOrder() {
		return new ResponseEntity<List<Order>>(orderService.getOrders(), HttpStatus.OK);
	}

}
