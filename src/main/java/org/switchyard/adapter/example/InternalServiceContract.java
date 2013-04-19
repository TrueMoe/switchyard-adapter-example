package org.switchyard.adapter.example;

public interface InternalServiceContract {
	boolean callInteralFaultMethod(Boolean throwException) /* throws FaultV2 */;
	public String toString();
}
