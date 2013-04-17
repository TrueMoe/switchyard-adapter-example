package org.switchyard.adapter.example.transformers;

import org.switchyard.adapter.example.domain.InputTypeV1;
import org.switchyard.adapter.example.domain.InputTypeV2;
import org.switchyard.annotations.Transformer;

public class InputTypeTransformer {
	@Transformer
	public InputTypeV2 toOrder(InputTypeV1 inputType) {
		return new InputTypeV2();
	}
}
