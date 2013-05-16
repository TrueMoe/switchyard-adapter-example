package org.switchyard.adapter.example;

import org.switchyard.adapter.example.domain.InputTypeV2;
import org.switchyard.adapter.example.domain.OutputTypeV2;
import org.switchyard.adapter.example.fault.FaultV2;
import org.switchyard.component.bean.Service;

@Service(ServiceContractV2.class)
public class ServiceContractV2Bean implements ServiceContractV2 {
	
	@Override
	public Boolean operationCanBeAdded() {
		return true;
	}

	@Override
	public Boolean operationNameCanChangeV2() {
		return true;
	}

	@Override
	public Boolean inputTypeCanChange(InputTypeV2 inputType) {
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
	public Boolean outputTypeCanBeRemoved() {
		return true;
	}

	@Override
	public Boolean faultCanBeAdded(Boolean throwException) throws FaultV2 {
		if (throwException) {
			throw new FaultV2("Should throw exception");
		}
		return true;
	}

	@Override
	public Boolean faultCanBeRemoved() {
		return true;
	}

	@Override
	public Integer faultCanChange(Integer value) throws FaultV2 {
		if (value == null) {
			throw new FaultV2("Should throw exception");
		}
		return value;
	}

}
