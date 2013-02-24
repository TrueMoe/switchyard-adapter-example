package com.objectbay.switchyard.adapter.example;

import com.objectbay.switchyard.adapter.example.domain.Order;

public interface OrderingService {

	boolean order(Order order);
	
	boolean cancel(Order order);
}
