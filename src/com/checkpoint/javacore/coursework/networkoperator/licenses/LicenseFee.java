package com.checkpoint.javacore.coursework.networkoperator.licenses;

public interface LicenseFee {
	
	int getId();
	String getName();
	int getLicenseFee();
	LicenseFee resetLicenseFee(int newValue);
	
	
}
