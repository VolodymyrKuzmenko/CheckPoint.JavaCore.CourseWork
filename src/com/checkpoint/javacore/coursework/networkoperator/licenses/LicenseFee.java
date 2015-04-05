package com.checkpoint.javacore.coursework.networkoperator.licenses;

import com.checkpoint.javacore.coursework.abonent.Information;

public interface LicenseFee {
	
	int getId();
	String getName();
	int getLicenseFee();
	LicenseFee resetLicenseFee(int newValue);
	Information getInformation();
	
}
