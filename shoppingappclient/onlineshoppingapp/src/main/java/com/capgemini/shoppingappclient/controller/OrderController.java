package com.capgemini.shoppingappclient.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.capgemini.shoppingappclient.entity.LineItem;
import com.capgemini.shoppingappclient.entity.Order;

@Controller
public class OrderController {

	private Set<LineItem> itemCart = new HashSet<>();

	@RequestMapping("/addToCart")
	public void addToCart(int customerId) {
		if (tempSet == null) {
			tempSet = new HashSet<>();
			tempSet.add(item);
		} else {
			tempSet.add(item);
		}
	}

	@RequestMapping("/addToCart")
	public void removeFromCart(LineItem item, int customerId) {
		Set<LineItem> tempSet = itemCart.get(customerId);
		if (tempSet != null) {
			tempSet.remove(item);
			itemCart.put(customerId, tempSet);
		}

	}

	@RequestMapping("/addToCart")
	public Set<LineItem> getCart(int customerId) {
		Set<LineItem> tempSet = itemCart.get(customerId);
		return tempSet;
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
