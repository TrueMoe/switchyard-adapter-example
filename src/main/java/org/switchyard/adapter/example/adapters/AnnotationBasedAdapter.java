package org.switchyard.adapter.example.adapters;

import org.switchyard.adapter.example.ServiceContractV1;
import org.switchyard.annotations.Adapter;
import org.switchyard.metadata.ServiceInterface;
import org.switchyard.metadata.ServiceOperation;

public class AnnotationBasedAdapter {

	@Adapter(contract = ServiceContractV1.class)
	public ServiceOperation lookup(String consumerOperation, ServiceInterface targetInterface) {
		if ("operationCanBeRemoved".equals(consumerOperation)) {
			return targetInterface.getOperation("operationCanBeAdded");
		} else if ("operationNameCanChangeV1".equals(consumerOperation)) {
			return targetInterface.getOperation("operationNameCanChangeV2");
		}
		return targetInterface.getOperation(consumerOperation);
	}

}
