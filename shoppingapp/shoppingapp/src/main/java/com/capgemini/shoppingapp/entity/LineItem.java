package com.capgemini.shoppingapp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ITEMS")
public class LineItem {
	@Id
	@GeneratedValue
	private int itemId;
	private int quantity;
	private int productId;

	public LineItem() {
		super();
	}

	public LineItem(int itemId, int quantity, int productId) {
		super();
		this.itemId = itemId;
		this.quantity = quantity;
		this.productId = productId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		return "LineItem [itemId=" + itemId + ", quantity=" + quantity + ", productId=" + productId + "]";
	}

}