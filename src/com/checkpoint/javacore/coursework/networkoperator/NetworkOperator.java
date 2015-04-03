package com.checkpoint.javacore.coursework.networkoperator;

import java.util.ArrayList;

import com.checkpoint.javacore.coursework.networkoperator.discoints.Discount;
import com.checkpoint.javacore.coursework.networkoperator.licenses.LicenseFee;
import com.checkpoint.javacore.coursework.networkoperator.packages.MobilePackage;
import com.checkpoint.javacore.coursework.networkoperator.tariffs.GeneralTariff;
import com.checkpoint.javacore.coursework.networkoperator.tariffs.GlobalTariif;

public class NetworkOperator {
	private ArrayList<NetworkOperator> networkOperators;
	private MobilePackage [] mobilePackages;
	private LicenseFee [] licenseFees;
	private Discount [] discounts;
	private GeneralTariff [] tariffs;
	private int countGlobalTariffs;
	private int countLocalTariffs;
	
	public GlobalTariif  getGlobalTariffsById(int id){
		int j = 0;
		for (GeneralTariff tariff : tariffs) {
			if(tariff.getClass().equals(GlobalTariif.class) && tariff.getId() == id){
				return (GlobalTariif) tariff;
			}
		}
		return null;
	}
	
}
