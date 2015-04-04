package com.checkpoint.javacore.coursework.networkoperator.tariffs;

import com.checkpoint.javacore.coursework.networkoperator.licenses.LicenseFee;
import com.checkpoint.javacore.coursework.networkoperator.taxcalculation.TaxCalculatingStrategy;

public class LocalTarif extends GeneralTariff {
	
	public LocalTarif(LicenseFee licenseFee ,int id, String name) {
		super(id, name);
		super.licenseFee = licenseFee;
	}
	
	public int calculateMoneyPay(int timeCall, TaxCalculatingStrategy strategy){
		strategy = strategy.addDiscount(discounts).addLicenseFee(licenseFee);
		if(strategy.isLinked()){
			strategy.addPeriodTime(timeCall);
			return strategy.calculate();			
		}else{
			strategy.addDiscount(discounts);
			strategy.addLicenseFee(licenseFee);
			strategy.addForeginOperatorValue(0);
			strategy.addPeriodTime(timeCall);
			return strategy.calculate();
			
		}
	}
	

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return super.getId();
	}

}
