package org.switchyard.adapter.example;

import javax.inject.Inject;

import org.switchyard.adapter.example.domain.InputTypeV2;
import org.switchyard.adapter.example.domain.OutputTypeV2;
import org.switchyard.adapter.example.fault.FaultV2;
import org.switchyard.component.bean.Reference;
import org.switchyard.component.bean.Service;

@Service(ServiceContractV2.class)
public class ServiceContractV2Bean implements ServiceContractV2 {
	@Inject @Reference
	InternalServiceContract service;
	
	@Override
	public boolean operationCanBeAdded() {
		return true;
	}

	@Override
	public boolean operationNameCanChangeV2() {
		return true;
	}

	@Override
	public boolean inputTypeCanChange(InputTypeV2 inputType) {
		return true;
	}

	@Override
	public OutputTypeV2 outputTypeCanChange() {
		return new OutputTypeV2();
	}

	@Override
	public OutputTypeV2 outputTypeCanBeAdded() {
		return new OutputTypeV2();
	}

	@Override
	public boolean outputTypeCanBeRemoved() {
		return true;
	}

	@Override
	public boolean faultCanBeAdded(Boolean throwException) throws FaultV2 {
		if (throwException) {
			throw new FaultV2("Should throw exception");
		}
		return true;
	}

	@Override
	public boolean faultCanBeRemoved() {
		return true;
	}

	@Override
	public boolean faultCanChange(Boolean throwException) throws FaultV2 {
		if (throwException) {
			throw new FaultV2("Should throw exception");
		}
		return true;
	}

	@Override
	public boolean internalFaultChange(Boolean throwException)  throws FaultV2{
		return service.fault(throwException);
	}

}
