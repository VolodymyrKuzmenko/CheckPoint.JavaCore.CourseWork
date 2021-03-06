package com.checkpoint.javacore.coursework.networkoperator.tariffs;

import com.checkpoint.javacore.coursework.abonent.Information;
import com.checkpoint.javacore.coursework.networkoperator.discoints.Discount;
import com.checkpoint.javacore.coursework.networkoperator.licenses.LicenseFee;

public class GeneralTariff {
	private int id;
	protected Discount[] discounts;
	
	protected LicenseFee licenseFee;
	protected String name;

	public GeneralTariff(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public GeneralTariff linkDiscounts(Discount... discounts) {
		this.discounts = discounts;
		return this;
	}

	public GeneralTariff setLicenseFee(LicenseFee fee) {
		this.licenseFee = fee;
		return this;
	}

	public int getId() {
		return id;
	}

	public boolean isUseDiscountById(int id) {
		for (Discount discount : discounts) {
			if (discount.getID() == id)
				return true;

		}
		return false;
	}

	public boolean isUseLicenseFeeById(int id) {
		if (licenseFee.getId() == id)
			return true;
		else
			return false;
	}
	
	public LicenseFee getLicenseFee() {
		return licenseFee;
	}
	public Discount[] getDiscounts() {
		return discounts;
	}
	
	public Information getInformation(){
		return null;
	}


}
