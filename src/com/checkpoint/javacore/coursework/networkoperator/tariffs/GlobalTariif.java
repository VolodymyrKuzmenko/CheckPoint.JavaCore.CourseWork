package com.checkpoint.javacore.coursework.networkoperator.tariffs;


import com.checkpoint.javacore.coursework.networkoperator.NetworkOperator;
import com.checkpoint.javacore.coursework.networkoperator.taxcalculation.TaxCalculatingStrategy;

public class GlobalTariif extends GeneralTariff {
	private NetworkOperator myOperator;
	
	public GlobalTariif(NetworkOperator myOperator, int id, String name) {
		super(id, name);
		this.myOperator = myOperator;
	}
	
	
//id стороннього оператора, куда дзвонитиму
	public int calculateMoneyPay(int timeCall, TaxCalculatingStrategy strategy, int idOperator){
		if(strategy.isLinked()){
			strategy.addPeriodTime(timeCall);
			return strategy.calculate();			
		}else{
			strategy.addDiscount(discounts);
			strategy.addLicenseFee(licenseFee);
			strategy.addForeginOperatorValue(myOperator.getForeginGlobalTariffValueByIdForeginOperator(idOperator));
			return strategy.calculate();
			
		}
	
	}
	
	
	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return super.getId();
	}

	

}
