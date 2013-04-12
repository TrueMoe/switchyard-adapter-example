package com.objectbay.switchyard.adapter.example;

import org.switchyard.component.bean.Service;

import com.objectbay.switchyard.adapter.example.domain.Order2;

@Service(OrderingService2.class)
public class OrderingServiceBean implements OrderingService2 {

	@Override
	public boolean orderIt(Order2 order) {
		order.setOrdered(true);
		return order.isOrdered();
	}

	@Override
	public boolean cancel(Order2 order) {
		order.setOrdered(false);
		return order.isOrdered();
	}

	@Override
	public Order2 outputTypeAdded(Order2 order) {
		orderIt(order);
		return order;
	}

	@Override
	public boolean faultCanBeAdded(Order2 order) throws Order2Fault {
		if (order.getName() == null || order.isOrdered()) { // check added in service contract version 2
			throw new Order2Fault("Invalid order: " + order.getName());
		}
		return orderIt(order);
	}
}
