package org.switchyard.adapter.example.soap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.switchyard.adapter.example.domain.InputTypeV2;
import org.switchyard.adapter.example.domain.OutputTypeV2;
import org.switchyard.adapter.example.fault.FaultV2;
import org.switchyard.annotations.Transformer;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public final class Transformers extends BaseTransformerUtil {
	Logger _logger = LoggerFactory.getLogger(Transformers.class);
	
	@Transformer(to = "{urn:com.objectbay:switchyard.adapter.example:0.0.1-SNAPSHOT}faultCanBeRemovedResponse")
	public Element transformBooleanToFaultCanBeRemovedResponse(Boolean from) {
		_logger.debug("faultCanBeRemovedResponse: Boolean -> Element");
		return createElement("faultCanBeRemovedResponse", "boolean", String.valueOf(from));
	}

	@Transformer(to = "{urn:com.objectbay:switchyard.adapter.example:0.0.1-SNAPSHOT}inputTypeCanChangeResponse")
	public Element transformBooleanToInputTypeCanChangeResponse(Boolean from) {
		_logger.debug("inputTypeCanChangeResponse: Boolean -> Element");
		return createElement("inputTypeCanChangeResponse", "boolean", String.valueOf(from));
	}

	@Transformer(to = "{urn:com.objectbay:switchyard.adapter.example:0.0.1-SNAPSHOT}operationCanBeAddedResponse")
	public Element transformBooleanToOperationCanBeAddedResponse(Boolean from) {
		_logger.debug("operationCanBeAddedResponse: Boolean -> Element");
		return createElement("operationCanBeAddedResponse", "boolean", String.valueOf(from));
	}

	@Transformer(to = "{urn:com.objectbay:switchyard.adapter.example:0.0.1-SNAPSHOT}operationNameCanChangeV2Response")
	public Element transformBooleanToOperationNameCanChangeV2Response(Boolean from) {
		_logger.debug("operationNameCanChangeV2Response: Boolean -> Element");
		return createElement("operationNameCanChangeV2Response", "boolean", String.valueOf(from));
	}

	@Transformer(to = "{urn:com.objectbay:switchyard.adapter.example:0.0.1-SNAPSHOT}outputTypeCanBeRemovedResponse")
	public Element transformBooleanToOutputTypeCanBeRemovedResponse(Boolean from) {
		_logger.debug("outputTypeCanBeRemovedResponse:  Boolean -> Element");
		return createElement("outputTypeCanBeRemovedResponse", "boolean", String.valueOf(from));
	}

	@Transformer(to = "{urn:com.objectbay:switchyard.adapter.example:0.0.1-SNAPSHOT}outputTypeCanBeAddedResponse")
	public Element transformOutputTypeV2ToOutputTypeCanBeAddedResponse(OutputTypeV2 from) {
		_logger.debug("outputTypeCanBeAddedResponse: OutputTypeV2 -> Element");
		return createElement("outputTypeCanBeAddedResponse", "outputTypeV2", null);
	}

	@Transformer(to = "{urn:com.objectbay:switchyard.adapter.example:0.0.1-SNAPSHOT}outputTypeCanChangeResponse")
	public Element transformOutputTypeV2ToOutputTypeCanChangeResponse(OutputTypeV2 from) {
		_logger.debug("outputTypeCanChangeResponse: OutputTypeV2 -> Element");
		return createElement("outputTypeCanChangeResponse", "outputTypeV2", null);
	}

	@Transformer(to = "{urn:com.objectbay:switchyard.adapter.example:0.0.1-SNAPSHOT}FaultV2")
	public Element transformFaultV2ToFaultV2(FaultV2 from) {
		_logger.debug("FaultV2: FaultV2 -> Element");
		return createElement("FaultV2", null, null);
	}

	@Transformer(from = "{urn:com.objectbay:switchyard.adapter.example:0.0.1-SNAPSHOT}faultCanBeAdded")
	public Boolean transformFaultCanBeAddedToBoolean(Element from) {
		_logger.debug("faultCanBeAdded: Element -> Boolean");
		Node n = getNode(from, "urn:faultCanBeAdded", "boolean");
		return Boolean.valueOf(n.getTextContent());
	}
	
	@Transformer(to = "{urn:com.objectbay:switchyard.adapter.example:0.0.1-SNAPSHOT}faultCanBeAddedResponse")
	public Element transformBooleanToFaultCanBeAddedResponse(Boolean from) {
		_logger.debug("faultCanBeAddedResponse: Boolean -> Element");
		return createElement("faultCanBeAddedResponse", "integer", String.valueOf(from));
	}

	@Transformer(from = "{urn:com.objectbay:switchyard.adapter.example:0.0.1-SNAPSHOT}faultCanChange")
	public Integer transformFaultCanChangeToInteger(Element from) {
		_logger.debug("faultCanChange: Element -> Integer");
		
		Node n = getNode(from, "urn:faultCanChange", "integer");
		return Integer.parseInt(n.getTextContent());
	}

	@Transformer(to = "{urn:com.objectbay:switchyard.adapter.example:0.0.1-SNAPSHOT}faultCanChangeResponse")
	public Element transformIntegerToFaultCanChangeResponse(Integer from) {
		_logger.debug("faultCanChangeResponse: Integer -> Element");
		return createElement("faultCanChangeResponse", "integer", String.valueOf(from));
	}

	@Transformer(from = "{urn:com.objectbay:switchyard.adapter.example:0.0.1-SNAPSHOT}inputTypeCanChange")
	public InputTypeV2 transformInputTypeCanChangeToInputTypeV2(Element from) {
		_logger.debug("inputTypeCanChange: Element -> InputTypeV2");
		return new InputTypeV2();
	}

}
