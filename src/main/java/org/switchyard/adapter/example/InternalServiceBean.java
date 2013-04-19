package org.switchyard.adapter.example;

import org.switchyard.component.bean.Service;

@Service(InternalService.class)
public class InternalServiceBean implements InternalService {

	@Override
	public boolean callInteralFaultMethod(Boolean throwException) {
		if (throwException) 
			; //throw new InternalFault("Internal fault");
		return true;
	}
}
