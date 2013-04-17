package org.switchyard.adapter.example;

import org.switchyard.adapter.example.fault.InternalFault;
import org.switchyard.component.bean.Service;

@Service(InternalService.class)
public class InternalServiceBean implements InternalService {

	@Override
	public boolean fault(Boolean throwException) throws InternalFault {
		if (throwException) 
			throw new InternalFault("Internal fault");
		return true;
	}

	@Override
	public String toString() {
		return super.toString();
	}
}
