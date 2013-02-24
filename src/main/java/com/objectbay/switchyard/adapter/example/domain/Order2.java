package com.objectbay.switchyard.adapter.example.domain;

public class Order2 {
	private String name;
	private boolean ordered;
	
	public Order2() {
		this(null, false);
	}

	public Order2(String name, boolean ordered) {
		this.name = name;
		this.ordered = ordered;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isOrdered() {
		return ordered;
	}

	public void setOrdered(boolean ordered) {
		this.ordered = ordered;
	}
}
