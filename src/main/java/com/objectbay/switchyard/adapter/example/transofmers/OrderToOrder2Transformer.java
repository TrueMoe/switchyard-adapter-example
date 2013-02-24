package com.objectbay.switchyard.adapter.example.transofmers;

import org.switchyard.annotations.Transformer;

import com.objectbay.switchyard.adapter.example.domain.Order;
import com.objectbay.switchyard.adapter.example.domain.Order2;

public class OrderToOrder2Transformer {

	@Transformer
	public Order2 toOrder(Order order) {
		Order2 or = new Order2();
		or.setOrdered(or.isOrdered());
		
		return or;
	}
}
