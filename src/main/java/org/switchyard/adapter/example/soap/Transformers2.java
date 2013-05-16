package org.switchyard.adapter.example.soap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.switchyard.adapter.example.domain.InputTypeV1;
import org.switchyard.adapter.example.domain.OutputTypeV1;
import org.switchyard.adapter.example.fault.FaultV1;
import org.switchyard.annotations.Transformer;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public final class Transformers2 extends BaseTransformerUtil {
	Logger _logger = LoggerFactory.getLogger(Transformers2.class);

	@Transformer(to = "{urn:com.objectbay:switchyard.adapter.example:0.0.1-SNAPSHOT}operationCanBeRemovedResponse")
	public Element transformBooleanToOperationCanBeRemovedResponse(Boolean from) {
		_logger.debug("operationCanBeRemovedResponse: Boolean -> Element");
		return createElement("operationCanBeRemovedResponse", "boolean", String.valueOf(from));
	}

	@Transformer(to = "{urn:com.objectbay:switchyard.adapter.example:0.0.1-SNAPSHOT}operationNameCanChangeV1Response")
	public Element transformBooleanToOperationNameCanChangeV1Response(Boolean from) {
		_logger.debug("operationNameCanChangeV1Response: Boolean -> Element");
		return createElement("operationNameCanChangeV1Response", "boolean", String.valueOf(from));
	}

	@Transformer(to = "{urn:com.objectbay:switchyard.adapter.example:0.0.1-SNAPSHOT}outputTypeCanChangeResponse")
	public Element transformOutputTypeV1ToOutputTypeCanChangeResponse(OutputTypeV1 from) {
		_logger.debug("outputTypeCanChangeResponse: OutputTypeV1 -> Element");
		return createElement("outputTypeCanChangeResponse", "outputTypeV1", null);
	}

	@Transformer(to = "{urn:com.objectbay:switchyard.adapter.example:0.0.1-SNAPSHOT}FaultV1")
	public Element transformFaultV1ToFaultV1(FaultV1 from) {
		_logger.debug("FaultV1: FaultV1 -> Element");
		return createElement("FaultV1", null, null);
	}

	@Transformer(from = "{urn:com.objectbay:switchyard.adapter.example:0.0.1-SNAPSHOT}faultCanBeRemoved")
	public Boolean transformFaultCanBeRemovedToBoolean(Element from) {
		_logger.debug("faultCanBeRemoved: Element -> Boolean");
		Node n = getNode(from, "urn:faultCanBeRemoved", "boolean");
		return Boolean.valueOf(n.getTextContent());
	}

	@Transformer(from = "{urn:com.objectbay:switchyard.adapter.example:0.0.1-SNAPSHOT}inputTypeCanChange")
	public InputTypeV1 transformInputTypeCanChangeToInputTypeV1(Element from) {
		_logger.debug("inputTypeCanChange: Element -> InputTypeV1");
		return new InputTypeV1();
	}

}
