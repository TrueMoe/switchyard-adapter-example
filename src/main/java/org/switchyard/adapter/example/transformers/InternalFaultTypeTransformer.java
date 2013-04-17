package org.switchyard.adapter.example.transformers;

import org.switchyard.adapter.example.fault.FaultV2;
import org.switchyard.adapter.example.fault.InternalFault;
import org.switchyard.annotations.Transformer;

public class InternalFaultTypeTransformer {
	@Transformer
	public FaultV2 toOrder(InternalFault fault) {
		return new FaultV2(fault.getMessage(), fault);
	}
}
