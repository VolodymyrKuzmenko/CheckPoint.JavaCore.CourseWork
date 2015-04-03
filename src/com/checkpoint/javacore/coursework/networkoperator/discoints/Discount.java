package com.checkpoint.javacore.coursework.networkoperator.discoints;

public interface Discount {
	
	int getID();
	String getName();
	int getDiscount();
	Discount resetDiscount(int value);
}
