package org.switchyard.adapter.example.fault;

public class FaultV1 extends Exception {
	private static final long serialVersionUID = -2165962602067468157L;

	public FaultV1(String message) {
		super(message);
	}

	public FaultV1(String message, Throwable cause) {
		super(message, cause);
	}
}
