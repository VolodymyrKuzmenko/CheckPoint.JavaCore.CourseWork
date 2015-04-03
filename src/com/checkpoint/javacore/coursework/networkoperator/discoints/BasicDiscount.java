package com.checkpoint.javacore.coursework.networkoperator.discoints;

public class BasicDiscount implements Discount {
	private int id;
	private int value;
	private String name;
	
	public BasicDiscount(int id, int value, String name) {
		super();
		this.id = id;
		this.value = value;
		this.name = name;
	}

	@Override
	public int getDiscount() {
		
		return value*-1;
	}

	@Override
	public Discount resetDiscount(int value) {
		this.value = value;
		return this;
	}

	@Override
	public int getID() {
		
		return this.id;
	}

	@Override
	public String getName() {
		return this.name;
	}

}
