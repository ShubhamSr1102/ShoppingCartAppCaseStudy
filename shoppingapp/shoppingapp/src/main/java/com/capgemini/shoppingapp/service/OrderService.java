package com.capgemini.shoppingapp.service;

import java.util.Set;

import com.capgemini.shoppingapp.entity.Order;
import com.capgemini.shoppingapp.exceptions.OrderNotFoundException;

public interface OrderService {

	public Set<Order> getOrders(int customerId) throws OrderNotFoundException;

	public Order getOrder(int orderId) throws OrderNotFoundException;

	public void submitOrder(Order order, int customerId);

	public void cancelOrder(int orderId) throws OrderNotFoundException;

	public void deleteOrder(Order order) throws OrderNotFoundException;
}
