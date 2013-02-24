package com.objectbay.switchyard.adapter.example;

import org.switchyard.component.bean.Service;

import com.objectbay.switchyard.adapter.example.domain.Order2;

@Service(OrderingService2.class)
public class OrderingServiceBean implements OrderingService2 {

//	@Override
//	public void order(Order order) {
//		order.setOrdered(true);
//	}
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

}
