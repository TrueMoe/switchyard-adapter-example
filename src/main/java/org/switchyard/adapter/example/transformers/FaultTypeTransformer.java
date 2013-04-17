package org.switchyard.adapter.example.transformers;

import org.switchyard.adapter.example.fault.FaultV1;
import org.switchyard.adapter.example.fault.FaultV2;
import org.switchyard.annotations.Transformer;

public class FaultTypeTransformer {
	@Transformer
	public FaultV1 toOrder(FaultV2 fault) {
		return new FaultV1(fault.getMessage(), fault);
	}
}
