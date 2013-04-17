package org.switchyard.adapter.example.fault;

public class FaultV2 extends Exception {
	private static final long serialVersionUID = -8781593565652416100L;

	public FaultV2(String message) {
		super(message);
	}

	public FaultV2(String message, Throwable cause) {
		super(message, cause);
	}
}
