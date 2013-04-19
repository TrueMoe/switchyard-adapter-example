package org.switchyard.adapter.example;

public interface InternalService {
	boolean callInteralFaultMethod(Boolean thorowException)/* throws InternalFault */;
}
