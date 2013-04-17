package org.switchyard.adapter.example.adapters;

import org.switchyard.annotations.Adapter;
import org.switchyard.metadata.ServiceInterface;
import org.switchyard.metadata.ServiceOperation;

public class ServiceContractAdapter {

	@Adapter(from = "{urn:com.objectbay:switchyard.adapter.example:0.0.1-SNAPSHOT}ServiceContractV1", 
			to = "{urn:com.objectbay:switchyard.adapter.example:0.0.1-SNAPSHOT}ServiceContractV2")
	public ServiceOperation lookup(String consumerOperation, ServiceInterface targetInterface) {
		if ("operationCanBeRemoved".equals(consumerOperation)) {
			return targetInterface.getOperation("operationCanBeAdded");
		} else if ("operationNameCanChangeV1".equals(consumerOperation)) {
			return targetInterface.getOperation("operationNameCanChangeV2");
		}
		return targetInterface.getOperation(consumerOperation);
	}

}
