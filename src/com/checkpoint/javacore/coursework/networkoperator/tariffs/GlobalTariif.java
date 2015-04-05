package com.checkpoint.javacore.coursework.networkoperator.tariffs;


import com.checkpoint.javacore.coursework.abonent.AbonentInformation;
import com.checkpoint.javacore.coursework.abonent.Information;
import com.checkpoint.javacore.coursework.networkoperator.NetworkOperator;
import com.checkpoint.javacore.coursework.networkoperator.discoints.Discount;
import com.checkpoint.javacore.coursework.networkoperator.taxcalculation.TaxCalculatingStrategy;

public class GlobalTariif extends GeneralTariff {
	private NetworkOperator myOperator;
	
	public GlobalTariif(NetworkOperator myOperator, int id, String name) {
		super(id, name);
		this.myOperator = myOperator;
	}
	
	
//id стороннього оператора, куда дзвонитиму
	public int calculateMoneyPay(int timeCall, TaxCalculatingStrategy strategy, int idOperator){
		strategy = strategy.addDiscount(discounts).addLicenseFee(licenseFee);
		if(strategy.isLinked()){
			strategy.addPeriodTime(timeCall);
			return strategy.calculate();			
		}else{
			strategy.addDiscount(discounts);
			strategy.addLicenseFee(licenseFee);
			strategy.addForeginOperatorValue(myOperator.getForeginGlobalTariffValueByIdForeginOperator(idOperator));
			strategy.addPeriodTime(timeCall);
			
			return strategy.calculate();
			
		}
	
	}
	
	
	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return super.getId();
	}
	@Override
	public Information getInformation(){
		AbonentInformation information = new AbonentInformation();
		information.addGlobalTariffInformation(name);
		if(discounts!=null)
		for (Discount discount : discounts) {
			information.addDiscountsInformation(discount.getName(), discount.getDiscount());
		}
		if(licenseFee!=null)
		information.addLicenseFeeInformation(licenseFee.getName(), licenseFee.getLicenseFee());
		return information;
	}

	

}
