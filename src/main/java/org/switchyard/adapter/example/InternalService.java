package org.switchyard.adapter.example;

import org.switchyard.adapter.example.fault.InternalFault;

public interface InternalService {
	boolean fault(Boolean throwException) throws InternalFault;
	
	public String toString();
}
