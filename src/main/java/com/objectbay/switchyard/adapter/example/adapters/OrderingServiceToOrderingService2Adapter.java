package com.objectbay.switchyard.adapter.example.adapters;

import org.switchyard.annotations.Adapter;
import org.switchyard.metadata.ServiceInterface;
import org.switchyard.metadata.ServiceOperation;

public class OrderingServiceToOrderingService2Adapter {

	@Adapter(from = "{urn:com.objectbay:switchyard.adapter.example:0.0.1-SNAPSHOT}OrderingService", 
			to = "{urn:com.objectbay:switchyard.adapter.example:0.0.1-SNAPSHOT}OrderingService2")
	public ServiceOperation lookup(String consumerOperation, ServiceInterface targetInterface) {
		if ("order".equals(consumerOperation)) {
			return targetInterface.getOperation("orderIt");
		}
		return targetInterface.getOperation(consumerOperation);
	}
}
