package com.objectbay.switchyard.adapter.example;

import com.objectbay.switchyard.adapter.example.domain.Order2;

public interface OrderingService2 {
	
	boolean orderIt(Order2 order);
	
	boolean cancel(Order2 order);
	
	Order2 outputTypeAdded(Order2 order);
	
	boolean faultCanBeAdded(Order2 order) throws Order2Fault;
}
