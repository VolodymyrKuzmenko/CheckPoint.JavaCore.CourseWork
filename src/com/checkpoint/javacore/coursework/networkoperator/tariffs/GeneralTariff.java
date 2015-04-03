package com.checkpoint.javacore.coursework.networkoperator.tariffs;

import com.checkpoint.javacore.coursework.networkoperator.discoints.Discount;
import com.checkpoint.javacore.coursework.networkoperator.licenses.LicenseFee;

public class GeneralTariff{
	private int id;
	protected Discount [] discounts;
	protected LicenseFee licenseFee;
	private int value;
	
	public int getTariff(){
		return value;
	}
	
	
	protected void protectedCalcTariff(int newValue){
		
	}
	
	public GeneralTariff linkDiscounts(Discount ... discounts){
		this.discounts = discounts;
		return this;
	}
	public GeneralTariff setLicenseFee(LicenseFee fee){
		this.licenseFee = fee;
		return this;
	}


	public int getId() {
		return id;
	}
	
}
