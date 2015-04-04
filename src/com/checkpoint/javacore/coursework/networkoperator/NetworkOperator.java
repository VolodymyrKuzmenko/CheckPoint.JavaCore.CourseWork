package com.checkpoint.javacore.coursework.networkoperator;

import java.util.ArrayList;



import com.checkpoint.javacore.coursework.network.Ground;
import com.checkpoint.javacore.coursework.networkoperator.discoints.Discount;
import com.checkpoint.javacore.coursework.networkoperator.licenses.LicenseFee;
import com.checkpoint.javacore.coursework.networkoperator.packages.MobilePackage;
import com.checkpoint.javacore.coursework.networkoperator.tariffs.GeneralTariff;
import com.checkpoint.javacore.coursework.networkoperator.tariffs.GlobalTariif;

public class NetworkOperator {
	private int operatorId;
	private ArrayList<NetworkOperator> networkOperators;
	private MobilePackage [] mobilePackages;
	private LicenseFee [] licenseFees;
	private Discount [] discounts;
	private GeneralTariff [] tariffs;
	private String operatorNumberCode;
	private Ground ground;
	
	
	public NetworkOperator addMobilePackages(MobilePackage...packages){
		this.mobilePackages = packages;
		return this;
	}
	
	public NetworkOperator addLicenceFee(LicenseFee...licenceFee){
		this.licenseFees = licenceFee;
		return this;
	}
	
	public NetworkOperator addDiscounts(Discount...discounts){
		this.discounts = discounts;
		return this;
	}
	
	public NetworkOperator addTariffs(GeneralTariff...tariffs){
		this.tariffs = tariffs;
		return this;
	}
	public NetworkOperator addGround(Ground ground){
		this.ground = ground;
		return this;
	}
	public NetworkOperator addOperatorId(int id){
		this.operatorId = id;
		return this;
	}
	
	public NetworkOperator addOperatorNumberCode(String code){
		this.operatorNumberCode = code;
		return this;
	}
	
	
	private int globalIdTariffId;
	
	public GlobalTariif  getGlobalTariffsById(int id){
	
		for (GeneralTariff tariff : tariffs) {
			if(tariff.getClass().equals(GlobalTariif.class) && tariff.getId() == id){
				return (GlobalTariif) tariff;
			}
		}
		return null;
	}
	public int getForeginGlobalTariffValueByIdForeginOperator(int id){
		for (NetworkOperator foreginOperator : networkOperators) {
				if(foreginOperator.getOperatorId()==id){
					return foreginOperator.getMyGlobalIdTariff();
				}

		}
		return -1;
	}

	public void setMyGlobalIdTariffId(int globalIdTariffid) {
		this.globalIdTariffId = globalIdTariffid;
	}
	
	public int getMyGlobalIdTariff() {
		return globalIdTariffId;
	}
	public int getOperatorId() {
		return operatorId;
	}
	public String getOperatorNumberCode() {
		return operatorNumberCode;
	}
	
	public Ground getGround() {
		return ground;
	}
	
	
}
