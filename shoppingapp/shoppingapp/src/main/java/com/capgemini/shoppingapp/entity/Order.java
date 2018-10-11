package com.capgemini.shoppingapp.entity;

import java.time.LocalDate;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

 @Document(collection = "order")
public class Order {

	@Id
	private int orderId;
	private double total;
	private int customerId;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate orderDate;
	private Set<LineItem> items;
	private String status;
	private boolean deleted;

	public Order() {
		super();
		status = "OK";
		deleted = false;
	}

	public Order(int orderId, double total, int customerId, LocalDate orderDate, Set<LineItem> items, String status,
			boolean deleted) {
		super();
		this.orderId = orderId;
		this.total = total;
		this.customerId = customerId;
		this.orderDate = orderDate;
		this.items = items;
		this.status = status;
		this.deleted = deleted;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public Set<LineItem> getItems() {
		return items;
	}

	public void setItems(Set<LineItem> items) {
		this.items = items;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", total=" + total + ", customerId=" + customerId + ", orderDate="
				+ orderDate + ", items=" + items + ", status=" + status + ", deleted=" + deleted + "]";
	}

}
