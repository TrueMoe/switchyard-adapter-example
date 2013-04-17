package org.switchyard.adapter.example.fault;

public class InternalFault extends Exception {
	private static final long serialVersionUID = -2165962602067468157L;

	public InternalFault(String message) {
		super(message);
	}

	public InternalFault(String message, Throwable cause) {
		super(message, cause);
	}
}
