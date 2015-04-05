package com.checkpoint.javacore.coursework.networkoperator;

import java.util.ArrayList;








import com.checkpoint.javacore.coursework.abonent.Abonent;
import com.checkpoint.javacore.coursework.abonent.PersonalAccaunt;
import com.checkpoint.javacore.coursework.alertsystem.NetworkOperatorSender;
import com.checkpoint.javacore.coursework.network.Ground;
import com.checkpoint.javacore.coursework.network.NetworkTower;
import com.checkpoint.javacore.coursework.networkoperator.discoints.Discount;
import com.checkpoint.javacore.coursework.networkoperator.licenses.LicenseFee;
import com.checkpoint.javacore.coursework.networkoperator.packages.MobilePackage;
import com.checkpoint.javacore.coursework.networkoperator.tariffs.GeneralTariff;
import com.checkpoint.javacore.coursework.networkoperator.tariffs.GlobalTariif;
import com.sun.org.apache.bcel.internal.generic.NEWARRAY;

public class NetworkOperator {
	private int operatorId;
	private ArrayList<NetworkOperator> networkOperators = new ArrayList<>();
	private MobilePackage [] mobilePackages;
	private LicenseFee [] licenseFees;
	private Discount [] discounts;
	private GeneralTariff [] tariffs;
	private String operatorNumberCode;
	private Ground ground;
	private ArrayList<PersonalAccaunt> accaunts = new ArrayList<PersonalAccaunt>();
	private ArrayList<Abonent> abonents = new ArrayList<Abonent>();
	private NetworkOperatorSender sender;
	
	
	public NetworkOperator() {
		
	}
	
	public MobilePackage getPakageById(int packageId){
		for (MobilePackage pack : mobilePackages) {
			if(pack.getId()==packageId){
				return pack;
			}
		}
		return null;
	}
	
	public void addAbonent(Abonent abonent){
		this.abonents.add(abonent);
	}
	
	public NetworkOperator addMobilePackages(MobilePackage...packages){
		this.mobilePackages = packages;
		return this;
	}
	
	public void addPersonalAccaunt(PersonalAccaunt accaunt){
		accaunts.add(accaunt);
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
	public NetworkOperator addGround(Ground ground, NetworkTower mainTowwer){
		this.ground = ground;
		setSender(new NetworkOperatorSender(this, abonents, ground, mainTowwer));
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
		return 0;
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
	
	public PersonalAccaunt getAcauntById(int id){
		for (PersonalAccaunt personalAccaunt : accaunts) {
			if (personalAccaunt.getAcauntId() == id){
				return personalAccaunt;
			}
		}
		return null;
	}


	public NetworkOperatorSender getSender() {
		return sender;
	}


	private void setSender(NetworkOperatorSender sender) {
		this.sender = sender;
	}
	
	public MobilePackage [] getAvaiblePackages(){
		return this.mobilePackages;
	}
	
	
}
