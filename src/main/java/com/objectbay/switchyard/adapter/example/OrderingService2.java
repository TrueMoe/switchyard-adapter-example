package com.objectbay.switchyard.adapter.example;

import com.objectbay.switchyard.adapter.example.domain.Order;

public interface OrderingService2 {
	
	void orderIt(Order order);
	
	void cancel(Order order);
}
