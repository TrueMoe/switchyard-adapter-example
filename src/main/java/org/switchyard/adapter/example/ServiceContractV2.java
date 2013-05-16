package org.switchyard.adapter.example;

import org.switchyard.adapter.example.domain.InputTypeV2;
import org.switchyard.adapter.example.domain.OutputTypeV2;
import org.switchyard.adapter.example.fault.FaultV2;

public interface ServiceContractV2 {

	/**
	 * This operation is only available of service consumers, which already use
	 * service contract v2. Service consumers using service contract v1 will not
	 * be affected.
	 * 
	 * @return true
	 */
	Boolean operationCanBeAdded();
	
	/**
	 * Consumers of service contract v2 have to handle the new fault type. 
	 * 
	 * @param value If null, throw FaultV2.
	 * @return value
	 * @throws FaultV2 Fault type of service contract v2.
	 */
	Integer faultCanChange(Integer value)  throws FaultV2;

	/**
	 * The operation name in service contract v1 changed.
	 * 
	 * @return true
	 */
	Boolean operationNameCanChangeV2();

	/**
	 * Consumers of service contract v2 can use the changed input type.
	 * 
	 * @param inputType Input type of service contract v2
	 * @return true
	 */
	Boolean inputTypeCanChange(InputTypeV2 inputType);

	/**
	 * Consumers of service contract v2 will receive the changed ouput type.
	 * 
	 * @return Output type of service contract v2
	 */
	OutputTypeV2 outputTypeCanChange();

	/**
	 * Consumers of service contract v2 will receive a response. MEP is InOut.
	 * 
	 * @return The added output type.
	 */
	OutputTypeV2 outputTypeCanBeAdded();

	/**
	 * WARNING: this feature is not supported! The operation in service contract
	 * v2 has no return value. As this feature is not supported by an adapter,
	 * this will break interoperability.
	 * 
	 * @return true
	 */
	void outputTypeCanBeRemoved();

	/**
	 * By adding an exception to service contract v2, the service might become
	 * incompatible with service contract v1. That depends on whether an error
	 * is triggered or not.
	 * 
	 * @param throwException Determines whether an error should be triggered.
	 * @return Whether an error should be triggered.
	 */
	Boolean faultCanBeAdded(Boolean throwException) throws FaultV2;

	// currently not supported.
	// boolean anAdditionalfaultCanBeAdded(boolean throwException) throws FaultV1, FaultV2;
	
	/**
	 * No fault will be triggered. 
	 * Interoperability can be guaranteed.
	 * 
	 * @return true
	 */
	Boolean faultCanBeRemoved();
}
