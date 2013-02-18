package com.objectbay.switchyard.adapter.example.domain;

public class Order {
	private boolean ordered;

	public Order() {
		this(false);
	}

	public Order(boolean ordered) {
		this.ordered = ordered;
	}

	public boolean isOrdered() {
		return ordered;
	}

	public void setOrdered(boolean ordered) {
		this.ordered = ordered;
	}
}
