package com.checkpoint.javacore.coursework.abonent;

import java.util.ArrayList;

public class AbonentInformation implements Information {
	private String packageInfo="";
	private String localTriffInfo="";
	private String globalTriffInfo="";
	private String licansefeeInfo="";
	private String [] discounts= new String[1];
	private String internetTariff="";
	private String calcStrategyInfo="";
	private String allStr = new String();
	private String composite="";
	
	@Override
	public Information addPakageInformation(String name, int id) {
		packageInfo = packageInfo+"\npackage: "+ name+ " id "+ id;
		return this;
	}

	@Override
	public Information addLocalTriffInformation(String name) {
		localTriffInfo = "\nlocal tariff "+ name;
		return this;
	}

	@Override
	public Information addGlobalTariffInformation(String name) {
		globalTriffInfo = "\nother network tariff: "+ name;
		return this;
	}

	@Override
	public Information addLicenseFeeInformation(String name, int value) {
		licansefeeInfo = "\nlicansefee: "+ name+", value:" + value;
		return this;
	}

	@Override
	public Information addDiscountsInformation(String name, int value) {
		String[] buf = new String[discounts.length];
		System.arraycopy(discounts, 0, buf, 0, buf.length);
		discounts = new String[buf.length+1];
		System.arraycopy(buf, 0, discounts, 0, buf.length);

		discounts[buf.length] = "\ndiscount: "+name+" value: "+value;
		return this;
	}

	@Override
	public Information addCalculationStrategyInformation(String name) {
		calcStrategyInfo="\npayment type: "+name;
		return this;
	}

	@Override
	public String buildInformation() {
		for (String string : linkToArray()) {
			if(string!=null)
			allStr+=string;
		}
		return allStr;
	}
	@Override
	public String toString() {
		
		return super.toString();
	}
	
	private ArrayList<String> linkToArray(){
		ArrayList<String> str = new ArrayList<String>();
		str.add(packageInfo);
		str.add(calcStrategyInfo);
		str.add(localTriffInfo);
		str.add(globalTriffInfo);
		str.add(internetTariff);
		str.add(licansefeeInfo);
		str.add(composite);
		for (String peaceOfInfo : discounts) {
			str.add(peaceOfInfo);
		}
		return str;
		
		
	}

	@Override
	public Information addCompositeInformation(String text) {
		composite ="\n"+ text;
		return this;
	}

	@Override
	public Information setLocalTarifInformation(String text) {
		localTriffInfo = text;
		return this;
	}

	@Override
	public Information setGlobalTarifInformation(String text) {
		globalTriffInfo = text;
		return this;
	}
	
}
