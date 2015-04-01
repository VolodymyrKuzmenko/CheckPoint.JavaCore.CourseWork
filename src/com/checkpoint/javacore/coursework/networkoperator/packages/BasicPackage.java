package com.checkpoint.javacore.coursework.networkoperator.packages;

import com.checkpoint.javacore.coursework.abonent.Information;
import com.checkpoint.javacore.coursework.networkoperator.licenses.LicenseFee;
import com.checkpoint.javacore.coursework.networkoperator.tariffs.GeneralTariff;

public class BasicPackage implements ConsumerPackage {

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setName() {
		// TODO Auto-generated method stub

	}

	@Override
	public LicenseFee getLicenseFee() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LicenseFee calcLicenseFee() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GeneralTariff[] getTariffs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GeneralTariff[] addTariff(GeneralTariff tariffNew) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Information getInformation(Class<Information> type) {
		// TODO Auto-generated method stub
		return null;
	}

}
