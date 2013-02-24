package com.objectbay.switchyard.adapter.example;

import com.objectbay.switchyard.adapter.example.domain.Order2;

public interface OrderingService2 {
	
	boolean orderIt(Order2 order);
	
	boolean cancel(Order2 order);
}
