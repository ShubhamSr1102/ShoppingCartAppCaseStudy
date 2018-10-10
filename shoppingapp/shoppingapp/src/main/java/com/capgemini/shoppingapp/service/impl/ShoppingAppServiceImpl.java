package com.capgemini.shoppingapp.service.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.shoppingapp.entity.LineItem;
import com.capgemini.shoppingapp.entity.Order;
import com.capgemini.shoppingapp.exceptions.OrderNotFoundException;
import com.capgemini.shoppingapp.repository.OrderRepository;
import com.capgemini.shoppingapp.service.LineItemService;
import com.capgemini.shoppingapp.service.OrderService;

@Service
public class ShoppingAppServiceImpl implements OrderService, LineItemService {

	@Autowired
	OrderRepository orderRepository;

	private HashMap<Integer, Set<LineItem>> map = new HashMap<>();

	@Override
	public void addLineItem(LineItem item, int customerId) {
		Set<LineItem> tempSet = map.get(customerId);
		if (tempSet == null) {
			tempSet = new HashSet<>();
			tempSet.add(item);
			map.put(customerId, tempSet);
		} else {
			tempSet.add(item);
			map.put(customerId, tempSet);
		}
	}

	@Override
	public void removeLineItem(LineItem item, int customerId) {
		Set<LineItem> tempSet = map.get(customerId);
		if (tempSet != null) {
			tempSet.remove(item);
			map.put(customerId, tempSet);
		}

	}

	@Override
	public Set<LineItem> getLineItems(int customerId) {
		Set<LineItem> tempSet = map.get(customerId);
		return tempSet;
	}

	@Override
	public Set<Order> getOrders(int customerId) throws OrderNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order getOrder(int orderId) throws OrderNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void submitOrder(Order order, int customerId) {
		Set<LineItem> tempSet = map.get(customerId);
	}

	@Override
	public void cancelOrder(int orderId) throws OrderNotFoundException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteOrder(Order order) throws OrderNotFoundException {
		// TODO Auto-generated method stub

	}

}
