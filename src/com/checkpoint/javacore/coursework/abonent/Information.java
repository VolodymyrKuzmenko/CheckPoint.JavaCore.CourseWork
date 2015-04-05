package com.checkpoint.javacore.coursework.abonent;

public interface Information {

	Information addPakageInformation(String name, int id);
	Information addLocalTriffInformation(String name);
	Information addGlobalTariffInformation(String name);
	Information addLicenseFeeInformation(String name, int value);
	Information addDiscountsInformation(String name, int value);
	Information addCalculationStrategyInformation(String name);
	Information addCompositeInformation(String text);
	Information setLocalTarifInformation(String text);
	Information setGlobalTarifInformation(String text);
	String buildInformation();
	
	
}
