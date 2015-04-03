package com.checkpoint.javacore.coursework.networkoperator.taxcalculation;

import com.checkpoint.javacore.coursework.networkoperator.discoints.Discount;
import com.checkpoint.javacore.coursework.networkoperator.licenses.LicenseFee;

public class OnePayForThirtyDayStrategy extends CommonStrategy implements TaxCalculatingStrategy {
	private int price;
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
		if(getDateCalls().getDay()==30){
			return price;
		}else{
			return 0;
		}
	}

	@Override
	public TaxCalculatingStrategy addForeginOperatorValue(int value) {
		super.addForeginOperatorValue(value);
		return this;
	}
	
	public void priceForThirtyDays(int value){
		this.price = value;
	}
	

}
