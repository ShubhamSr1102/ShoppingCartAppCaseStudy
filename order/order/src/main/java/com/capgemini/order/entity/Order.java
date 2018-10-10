package com.capgemini.order.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "ORDER")
public class Order {

	@Id
	@Column(name = "order_id")
	private int orderId;
	private int productId;
	private int customerId;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate orderDate;
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private List<LineItem> items;

	public Order() {
		super();
	}

	public Order(int orderId, int productId, int customerId, LocalDate orderDate) {
		super();
		this.orderId = orderId;
		this.productId = productId;
		this.customerId = customerId;
		this.orderDate = orderDate;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", productId=" + productId + ", customerId=" + customerId
				+ ", customerDateOfBirth=" + orderDate + "]";
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public LocalDate getorderDate() {
		return orderDate;
	}

	public void setorderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

}
