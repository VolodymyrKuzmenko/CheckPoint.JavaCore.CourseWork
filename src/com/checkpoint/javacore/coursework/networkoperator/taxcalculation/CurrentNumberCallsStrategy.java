package com.checkpoint.javacore.coursework.networkoperator.taxcalculation;

import com.checkpoint.javacore.coursework.networkoperator.discoints.Discount;
import com.checkpoint.javacore.coursework.networkoperator.licenses.LicenseFee;

public class CurrentNumberCallsStrategy extends CommonStrategy implements TaxCalculatingStrategy  {
	private int numberCalls = 0;
	
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

	@SuppressWarnings("deprecation")
	@Override
	public int calculate() {
		if(numberCalls == countCalls){
			return (foreginOperatorValue+fee.getLicenseFee()+ calculateDiscountValue())*getDateCalls().getMinutes();
		}else{
			return 0;
		}
	}

	@Override
	public TaxCalculatingStrategy addForeginOperatorValue(int value) {
		super.addForeginOperatorValue(value);
		return this;
	}
	
	public TaxCalculatingStrategy setMaxNumberCalls(int maxNumbercalls){
		this.numberCalls = maxNumbercalls;
		return this;
	}
	

}
