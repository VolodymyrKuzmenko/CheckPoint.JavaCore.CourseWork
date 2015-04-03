package com.checkpoint.javacore.coursework.networkoperator.packages;

import com.checkpoint.javacore.coursework.abonent.Information;
import com.checkpoint.javacore.coursework.networkoperator.tariffs.GlobalTariif;
import com.checkpoint.javacore.coursework.networkoperator.tariffs.LocalTarif;

public interface MobilePackage {
	 int getId();
	 String getName();
	 MobilePackage setLocalTariff(LocalTarif tariffNew);
	 MobilePackage setGlobalTariff(GlobalTariif tariffNew);
	 Information getInformation(Class<Information> type);
	 int calculateCharge(int time, int abonentKey, int foreginOperator);
	
}
