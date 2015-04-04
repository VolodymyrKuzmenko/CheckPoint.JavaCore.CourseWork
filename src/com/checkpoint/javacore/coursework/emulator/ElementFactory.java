package com.checkpoint.javacore.coursework.emulator;

import java.util.ArrayList;

import com.checkpoint.javacore.coursework.network.Ground;
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
	private ArrayList<GlobalTariif> globalTariifs = new ArrayList<GlobalTariif>();
	private ArrayList<MobilePackage> packages = new ArrayList<MobilePackage>();
private ArrayList<LocalTarif> localTarifs = new ArrayList<LocalTarif>();
	
	public LicenseFee buildLicenseFee(int value, int id, String name) {
		licenseFees.add(new BasicLicenseFee(value, id, name));
		return licenseFees.get(licenseFees.size() - 1);
	}

	public Discount buildDiscount(int value, int id, String name) {
		discounts.add(new BasicDiscount(id, value, name));
		return discounts.get(discounts.size() - 1);
	}

	public GeneralTariff buildGlobalTariff(int id, String name) {
		globalTariifs.add(new GlobalTariif(operator, id, name));
		return globalTariifs.get(globalTariifs.size() - 1);
	}

	public GeneralTariff buildLocalTariff(int id, String name,
			LicenseFee licenseFee) {
		localTarifs.add(new LocalTarif(licenseFee, id, name));
		return localTarifs.get(licenseFees.size()-1);
	}

	public MobilePackage buildMobilePackage(String name, int id,
			GlobalTariif globalTariif, LocalTarif localTarif) {
		return new BasicPackage(name, id).setGlobalTariff(globalTariif)
				.setLocalTariff(localTarif);
	}

	public NetworkOperator buildNetworkOperator(Ground ground, int id) {
		Discount[] discountsN = new Discount[discounts.size()];
		discountsN = discounts.toArray(discountsN);
		LicenseFee[] licenseFeesN = new LicenseFee[licenseFees.size()];
		licenseFeesN = licenseFees.toArray(licenseFeesN);
		MobilePackage[] packagesN = new MobilePackage[packages.size()];
		packagesN = packages.toArray(packagesN);
		
		ArrayList<GeneralTariff> generalTariffs = new ArrayList<GeneralTariff>();
		generalTariffs.addAll(globalTariifs);
		generalTariffs.addAll(localTarifs);
		
		GeneralTariff [] generalTariffsN = new GeneralTariff[generalTariffs.size()-1];
		generalTariffsN = generalTariffs.toArray(generalTariffsN);
		
		operator.setMyGlobalIdTariffId(globalTariifs.get(0).getId());
		
		return operator.addDiscounts(discountsN)
				.addGround(ground)
				.addLicenceFee(licenseFeesN)
				.addMobilePackages(packagesN)
				.addOperatorId(id)
				.addOperatorNumberCode(Integer.toString(id) + "23")
				.addTariffs(generalTariffsN);

	}
}
