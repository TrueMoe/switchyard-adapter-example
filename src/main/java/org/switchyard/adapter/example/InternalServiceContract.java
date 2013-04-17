package org.switchyard.adapter.example;

import org.switchyard.adapter.example.fault.FaultV2;

public interface InternalServiceContract {
	boolean fault(Boolean throwException) throws FaultV2;
	public String toString();
}
