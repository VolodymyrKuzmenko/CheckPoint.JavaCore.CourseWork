package com.checkpoint.javacore.coursework.networkoperator.taxcalculation;

public class StrategyCalculationPool {
	@SuppressWarnings("rawtypes")
	private static Class [] strategys = {CurrentNumberCallsStrategy.class, OnePayForThirtyDayStrategy.class, TaxPerMinutesStrategy.class};
	
	public static TaxCalculatingStrategy getStrategy(@SuppressWarnings("rawtypes") Class type){
		if(type.equals(strategys[0])){
			return new CurrentNumberCallsStrategy();
		}
		if(type.equals(strategys[1])){
			return new OnePayForThirtyDayStrategy();
		}
		if(type.equals(strategys[2])){
			return new TaxPerMinutesStrategy();
		}
		else{
			return null;
		}
	}
}
