package com.checkpoint.javacore.coursework.emulator;

import java.util.ArrayList;

import com.checkpoint.javacore.coursework.network.Ground;
import com.checkpoint.javacore.coursework.network.NetworkTower;
import com.checkpoint.javacore.coursework.network.Position;
import com.checkpoint.javacore.coursework.networkoperator.NetworkOperator;
import com.checkpoint.javacore.coursework.networkoperator.discoints.BasicDiscount;
import com.checkpoint.javacore.coursework.networkoperator.discoints.Discount;
import com.checkpoint.javacore.coursework.networkoperator.licenses.BasicLicenseFee;
import com.checkpoint.javacore.coursework.networkoperator.licenses.LicenseFee;
import com.checkpoint.javacore.coursework.networkoperator.packages.BasicPackage;
import com.checkpoint.javacore.coursework.networkoperator.packages.MobilePackage;
import com.checkpoint.javacore.coursework.networkoperator.tariffs.GeneralTariff;
import com.checkpoint.javacore.coursework.networkoperator.tariffs.GlobalTariif;
import com.checkpoint.javacore.coursework.networkoperator.tariffs.LocalTarif;

public class ElementFactory {
	private NetworkOperator operator = new NetworkOperator();
	private ArrayList<LicenseFee> licenseFees = new ArrayList<LicenseFee>();
	private ArrayList<Discount> discounts = new ArrayList<Discount>();
	private ArrayList<GlobalTariif> globalTarifs = new ArrayList<GlobalTariif>();
	private ArrayList<MobilePackage> packages = new ArrayList<MobilePackage>();
private ArrayList<LocalTarif> localTarifs = new ArrayList<LocalTarif>();

private ArrayList<NetworkTower> towers = new ArrayList<NetworkTower>();
	
	public LicenseFee buildLicenseFee(int value, int id, String name) {
		licenseFees.add(new BasicLicenseFee(value, id, name));
		return licenseFees.get(licenseFees.size() - 1);
	}

	public Discount buildDiscount(int value, int id, String name) {
		discounts.add(new BasicDiscount(id, value, name));
		return discounts.get(discounts.size() - 1);
	}

	public GeneralTariff buildGlobalTariff(int id, String name) {
		globalTarifs.add(new GlobalTariif(operator, id, name));
		globalTarifs.get(0).linkDiscounts(discounts.get(0)).setLicenseFee(licenseFees.get(1));
		return globalTarifs.get(globalTarifs.size() - 1);
	}

	public GeneralTariff buildLocalTariff(int id, String name,
			LicenseFee licenseFee) {
		localTarifs.add(new LocalTarif(licenseFee, id, name));
		localTarifs.get(localTarifs.size()-1).linkDiscounts(discounts.get(0));
		return localTarifs.get(localTarifs.size()-1);
	}

	public MobilePackage buildMobilePackage(String name, int id,
			GlobalTariif globalTariif, LocalTarif localTarif) {
		MobilePackage pack = new BasicPackage(name, id).setGlobalTariff(globalTariif)
				.setLocalTariff(localTarif);
		packages.add(pack);
		return pack; 
	}

	public NetworkOperator buildNetworkOperator(Ground ground, int id) {
		Discount[] discountsN = new Discount[discounts.size()];
		discountsN = discounts.toArray(discountsN);
		LicenseFee[] licenseFeesN = new LicenseFee[licenseFees.size()];
		licenseFeesN = licenseFees.toArray(licenseFeesN);
		MobilePackage[] packagesN = new MobilePackage[packages.size()];
		packagesN = packages.toArray(packagesN);
		
		ArrayList<GeneralTariff> generalTariffs = new ArrayList<GeneralTariff>();
		generalTariffs.addAll(globalTarifs);
		generalTariffs.addAll(localTarifs);
		
		GeneralTariff [] generalTariffsN = new GeneralTariff[generalTariffs.size()-1];
		generalTariffsN = generalTariffs.toArray(generalTariffsN);
		
		operator.setMyGlobalIdTariffId(globalTarifs.get(0).getId());
		
		return operator.addDiscounts(discountsN)
				.addGround(ground, towers.get(0))
				.addLicenceFee(licenseFeesN)
				.addMobilePackages(packagesN)
				.addOperatorId(id)
				.addOperatorNumberCode(Integer.toString(id) + "23")
				.addTariffs(generalTariffsN);

	}
	
	public NetworkTower buildNetworkTower(int x, int y){
		towers.add(new NetworkTower(5, 50, new Position(x,y)));
		return towers.get(towers.size()-1);
	}
	
	public Ground buildGround(){
		NetworkTower [] towersN = new NetworkTower[towers.size()];
		towersN = towers.toArray(towersN);
		Ground ground = new Ground();
		ground.addTower(towersN);
		return ground;
	}
	
}
