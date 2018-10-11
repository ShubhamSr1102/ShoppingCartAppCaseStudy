package com.capgemini.shoppingapp.service.impl;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.shoppingapp.entity.LineItem;
import com.capgemini.shoppingapp.entity.Order;
import com.capgemini.shoppingapp.exceptions.OrderNotFoundException;
import com.capgemini.shoppingapp.repository.OrderRepository;
import com.capgemini.shoppingapp.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository orderRepository;

	private HashMap<Integer, Set<LineItem>> itemCart = new HashMap<>();

	@Override
	public void addLineItem(LineItem item, int customerId) {
		Set<LineItem> tempSet = itemCart.get(customerId);
		if (tempSet == null) {
			tempSet = new HashSet<>();
			tempSet.add(item);
			itemCart.put(customerId, tempSet);
		} else {
			tempSet.add(item);
			itemCart.put(customerId, tempSet);
		}
	}

	@Override
	public void removeLineItem(LineItem item, int customerId) {
		Set<LineItem> tempSet = itemCart.get(customerId);
		if (tempSet != null) {
			tempSet.remove(item);
			itemCart.put(customerId, tempSet);
		}

	}

	@Override
	public Set<LineItem> getLineItems(int customerId) {
		Set<LineItem> tempSet = itemCart.get(customerId);
		return tempSet;
	}

	@Override
	public List<Order> getOrders() throws OrderNotFoundException {
		return orderRepository.findByDeleted("false");
	}

	@Override
	public Order getOrder(int orderId) throws OrderNotFoundException {
		Optional<Order> optionalOrder = orderRepository.findById(orderId);
		if (optionalOrder.isPresent()) {
			if (!optionalOrder.get().isDeleted())
				return optionalOrder.get();
		}
		throw new OrderNotFoundException("Order does not exist!");
	}

	@Override
	public Order submitOrder(Order order) {
		order.setOrderDate(LocalDate.now());
		// order.setItems(itemCart.get(order.getCustomerId()));
		return orderRepository.save(order);
	}

	@Override
	public void deleteOrder(int orderId) throws OrderNotFoundException {
		Optional<Order> optionalOrder = orderRepository.findById(orderId);
		if (optionalOrder.isPresent()) {
			if (!optionalOrder.get().isDeleted()) {
				optionalOrder.get().setDeleted(true);
				orderRepository.save(optionalOrder.get());
			}
		} else
			throw new OrderNotFoundException("Order does not exist!");
	}

	@Override
	public Order cancelOrder(int orderId) throws OrderNotFoundException {
		Optional<Order> optionalOrder = orderRepository.findById(orderId);
		if (optionalOrder.isPresent()) {
			if (!optionalOrder.get().isDeleted()) {
				optionalOrder.get().setStatus("CANCELLED");
				orderRepository.save(optionalOrder.get());
				return optionalOrder.get();
			}
		}
		throw new OrderNotFoundException("Order does not exist!");
	}

}
