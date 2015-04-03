package com.checkpoint.javacore.coursework.networkoperator.taxcalculation;

import com.checkpoint.javacore.coursework.networkoperator.discoints.Discount;
import com.checkpoint.javacore.coursework.networkoperator.licenses.LicenseFee;

public interface TaxCalculatingStrategy {
	TaxCalculatingStrategy addPeriodTime(long time);
	TaxCalculatingStrategy addDiscount(Discount ... discounts);
	TaxCalculatingStrategy addLicenseFee(LicenseFee fee);
	TaxCalculatingStrategy addForeginOperatorValue(int value);
	TaxCalculatingStrategy removeLinks();
	boolean isLinked();
	
	int calculate();
}
