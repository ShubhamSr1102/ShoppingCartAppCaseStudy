package com.capgemini.shoppingapp.service;

import java.util.List;
import java.util.Set;

import com.capgemini.shoppingapp.entity.LineItem;
import com.capgemini.shoppingapp.entity.Order;
import com.capgemini.shoppingapp.exceptions.OrderNotFoundException;

public interface OrderService {

	public void addLineItem(LineItem item, int customerId);

	public void removeLineItem(LineItem item, int customerId);

	public Set<LineItem> getLineItems(int customerId);
	
	public List<Order> getOrders() throws OrderNotFoundException;

	public Order getOrder(int orderId) throws OrderNotFoundException;

	public Order submitOrder(Order order);

	public Order cancelOrder(int orderId) throws OrderNotFoundException;

	public void deleteOrder(int orderId) throws OrderNotFoundException;

}
