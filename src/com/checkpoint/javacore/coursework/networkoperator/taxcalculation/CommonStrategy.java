package com.checkpoint.javacore.coursework.networkoperator.taxcalculation;

import java.util.Date;

import com.checkpoint.javacore.coursework.networkoperator.discoints.Discount;
import com.checkpoint.javacore.coursework.networkoperator.licenses.LicenseFee;

public abstract class CommonStrategy implements TaxCalculatingStrategy {

	protected int countCalls = 0;
	protected long miliseconds =0;
	protected Discount [] discounts;
	protected LicenseFee fee;
	protected int foreginOperatorValue = 0;
	
	@Override
	public TaxCalculatingStrategy addPeriodTime(long time) {
		countCalls++;
		this.miliseconds = time;
		return this;
	}

	@Override
	public TaxCalculatingStrategy addDiscount(Discount... discounts) {
		this.discounts = discounts;
		return this;
	}

	@Override
	public TaxCalculatingStrategy addLicenseFee(LicenseFee fee) {
		this.fee = fee;
		return this;
	}

	@Override
	public TaxCalculatingStrategy addForeginOperatorValue(int value) {
		foreginOperatorValue = value;
		return this;
	}

	@Override
	public abstract int calculate();

	@Override
	public TaxCalculatingStrategy removeLinks(){
		discounts = null;
		fee = null;
		foreginOperatorValue = 0;
		return this;
	}
	
	@Override
	public boolean isLinked() {
		return foreginOperatorValue!=0 && fee != null && discounts!=null;
	};
	
	protected int calculateDiscountValue() {
		int discountValue = 0;
		for (Discount discount : discounts) {
			discountValue+=discount.getDiscount();
		}
		return discountValue;
	}
	
	
	
	protected Date getDateCalls(){
		return new Date(miliseconds);
	}
}
