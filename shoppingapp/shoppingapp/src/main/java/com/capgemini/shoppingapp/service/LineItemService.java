package com.capgemini.shoppingapp.service;

import java.util.Set;

import com.capgemini.shoppingapp.entity.LineItem;

public interface LineItemService {

	public void addLineItem(LineItem item, int customerId);

	public void removeLineItem(LineItem item, int customerId);

	public Set<LineItem> getLineItems(int customerId);
}
