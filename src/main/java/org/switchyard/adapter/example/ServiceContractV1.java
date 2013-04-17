package org.switchyard.adapter.example;

import org.switchyard.adapter.example.domain.InputTypeV1;
import org.switchyard.adapter.example.domain.OutputTypeV1;
import org.switchyard.adapter.example.fault.FaultV1;

public interface ServiceContractV1 {

	/**
	 * This operation can be removed in service contract v2. 
	 * An adapter can be used to map to another operation 
	 * defined in service contract v2 to remain interoperable.
	 * 
	 * @return true
	 */
	boolean operationCanBeRemoved();
	
	/**
	 * The operation name can change in service contract v2. 
	 * An adapter can be used to map to this operation.
	 * 
	 * @return true
	 */
	boolean operationNameCanChangeV1();
	
	/**
	 * The input type of the operation changes in service contract v2.
	 * A transformer can be used to convert the input type. 
	 * 
	 * @param inputType Input type that changes
	 * @return true
	 */
	boolean inputTypeCanChange(InputTypeV1 inputType);
	
	/**
	 * The output type of the operation changes in service contract v2. 
	 * A transformer can be used to convert the output type.
	 * 
	 * @return Output type that changes
	 */
	OutputTypeV1 outputTypeCanChange();
	
	/**
	 * The operation in service contract v1 has no output type.
	 * A new output type in service contract v2 will not break interoperability.
	 * Although an output type is added in service contract v2, consumers of
	 * the service contract v1 will not receive a response. 
	 * MEP (InOnly) will not change.  
	 */
	void outputTypeCanBeAdded();
	
	/**
	 * WARNING: this feature is not supported!
	 * As the service contract v2 has no return value, an adapter
	 * might be used to return a dummy value.
	 * As this feature is not supported by an adapter, this will break 
	 * interoperability.
	 * 
	 * @return A dummy value ...
	 */
	boolean outputTypeCanBeRemoved();
	
	/**
	 * By adding an exception to service contract v2, 
	 * the service might become incompatible with service contract v1.
	 * That depends on whether an error is triggered or not.
	 * 
	 * @param throwException Determines whether an error should be triggered.
	 * @return Whether an error should be triggered.
	 */
	boolean faultCanBeAdded(boolean throwException);
	
	// currently not supported.
	// boolean anAdditionalfaultCanBeAdded(boolean throwException) throws FaultV1;
	
	/**
	 * The exception will no longer occurs. 
	 * Interoperability can be guaranteed.  
	 */
	boolean faultCanBeRemoved(Boolean throwException) throws FaultV1;
	
	/**
	 * The fault type in service contract v2 will change.
	 * A transformer can be used to to map type fault type. 
	 * 
	 * @throws FaultV1 Fault type of service contract v1.
	 */
	boolean faultCanChange() throws FaultV1;
}
