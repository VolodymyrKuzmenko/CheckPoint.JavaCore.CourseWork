package com.checkpoint.javacore.coursework.networkoperator.packages;

import com.checkpoint.javacore.coursework.abonent.Information;
import com.checkpoint.javacore.coursework.networkoperator.licenses.LicenseFee;
import com.checkpoint.javacore.coursework.networkoperator.tariffs.GeneralTariff;

public interface ConsumerPackage {
	 int getId();
	 String getName();
	 void setName();
	 LicenseFee getLicenseFee();
	 LicenseFee calcLicenseFee();
	 GeneralTariff [] getTariffs();
	 GeneralTariff [] addTariff(GeneralTariff tariffNew);
	 Information getInformation(Class<Information> type);
	 
	
}
