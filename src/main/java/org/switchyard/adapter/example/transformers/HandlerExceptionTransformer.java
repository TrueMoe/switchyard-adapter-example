package org.switchyard.adapter.example.transformers;

import org.switchyard.HandlerException;
import org.switchyard.adapter.example.fault.FaultV2;
import org.switchyard.annotations.Transformer;

public class HandlerExceptionTransformer {

	@Transformer
	public FaultV2 transform(HandlerException fault) {
		return (FaultV2) fault.getCause();
	}
}
