package org.switchyard.adapter.example.transformers;

import org.switchyard.adapter.example.domain.OutputTypeV1;
import org.switchyard.adapter.example.domain.OutputTypeV2;
import org.switchyard.annotations.Transformer;

public class OutputTypeTransformer {
	@Transformer
	public OutputTypeV1 toOrder(OutputTypeV2 inputType) {
		return new OutputTypeV1();
	}
}
