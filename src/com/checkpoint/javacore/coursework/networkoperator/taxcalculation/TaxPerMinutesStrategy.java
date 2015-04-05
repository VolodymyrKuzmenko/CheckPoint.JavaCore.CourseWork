package com.checkpoint.javacore.coursework.networkoperator.taxcalculation;


import com.checkpoint.javacore.coursework.networkoperator.discoints.Discount;
import com.checkpoint.javacore.coursework.networkoperator.licenses.LicenseFee;

public class TaxPerMinutesStrategy  extends CommonStrategy implements TaxCalculatingStrategy {
	public final String name ="pay for minutes";
	
	
	@Override
	public TaxCalculatingStrategy addPeriodTime(long time) {
		super.addPeriodTime(time);
		return this;
	}

	@Override
	public TaxCalculatingStrategy addDiscount(Discount... discounts) {
		super.addDiscount(discounts);
		return this;
	}

	@Override
	public TaxCalculatingStrategy addLicenseFee(LicenseFee fee) {
		super.addLicenseFee(fee);
		return this;
	}

	@Override
	public TaxCalculatingStrategy addForeginOperatorValue(int value) {
		super.addForeginOperatorValue(value);
		return this;
	}

	@SuppressWarnings("deprecation")
	@Override
	public int calculate() {
		return (foreginOperatorValue+fee.getLicenseFee()- calculateDiscountValue())*getDateCalls().getMinutes()*-1;
	}
	@Override
	public String getDescription() {
		
		return this.name;
	}
	

	

}
