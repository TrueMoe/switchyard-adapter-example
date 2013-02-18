package com.objectbay.switchyard.adapter.example;

import com.objectbay.switchyard.adapter.example.domain.Order;

public interface OrderingService {

	void order(Order order);
	
	void cancel(Order order);
}
