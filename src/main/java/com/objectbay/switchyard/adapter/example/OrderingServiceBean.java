package com.objectbay.switchyard.adapter.example;

import org.switchyard.component.bean.Service;

import com.objectbay.switchyard.adapter.example.domain.Order;

@Service(OrderingService2.class)
public class OrderingServiceBean implements OrderingService2 {

//	@Override
//	public void order(Order order) {
//		order.setOrdered(true);
//	}
	@Override
	public void orderIt(Order order) {
		order.setOrdered(true);
	}

	@Override
	public void cancel(Order order) {
		order.setOrdered(false);
	}

}
