package com.checkpoint.javacore.coursework.networkoperator.discoints;

import com.checkpoint.javacore.coursework.abonent.Information;

public interface Discount {
	
	int getID();
	String getName();
	int getDiscount();
	Discount resetDiscount(int value);
	Information getInformation();
}
