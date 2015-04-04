package com.checkpoint.javacore.coursework.emulator;

import com.checkpoint.javacore.coursework.abonent.Abonent;
import com.checkpoint.javacore.coursework.network.Ground;
import com.checkpoint.javacore.coursework.networkoperator.NetworkOperator;
import com.checkpoint.javacore.coursework.networkoperator.licenses.LicenseFee;
import com.checkpoint.javacore.coursework.networkoperator.packages.MobilePackage;
import com.checkpoint.javacore.coursework.networkoperator.tariffs.GeneralTariff;
import com.checkpoint.javacore.coursework.networkoperator.tariffs.GlobalTariif;
import com.checkpoint.javacore.coursework.networkoperator.tariffs.LocalTarif;

public class SimpleEmulator {

	public static void main(String[] args) {
	ElementFactory factory = new ElementFactory();
	
	LicenseFee fee3 = factory.buildLicenseFee(7, 3, "fee3");
	
	
	factory.buildDiscount(-2, 1, "descount1");
	factory.buildDiscount(-3, 2, "descount2");
	factory.buildDiscount(-4, 3, "descount3");
	
;
	factory.buildLocalTariff(1, "local1", factory.buildLicenseFee(5, 1, "fee1"));
	GeneralTariff t = factory.buildLocalTariff(2, "local1", factory.buildLicenseFee(6, 2, "fee1"));
	
	MobilePackage p = factory.buildMobilePackage("simple package", 1,	(GlobalTariif) factory.buildGlobalTariff(10, "global1") ,(LocalTarif) t);
	

	factory.buildNetworkTower(10, 10);
	factory.buildNetworkTower(0, 20);
	factory.buildNetworkTower(20, 50);
	factory.buildNetworkTower(50, 100);
	factory.buildNetworkTower(100, 100);
	factory.buildNetworkTower(100, 50);
	
	Ground g = factory.buildGround();
	
	NetworkOperator operator = factory.buildNetworkOperator(g, 1);
	
	
	
	Abonent ab = new Abonent(g,1).linkMobilePackage(p).linkOperator(operator).linkNumber("234234").linkPersonalAcaunt(500, 1).linkAbonentPosition(100, 100);
	
	Abonent ba = new Abonent(g,2).linkMobilePackage(p).linkOperator(operator).linkNumber("678678").linkPersonalAcaunt(500, 2).linkAbonentPosition(0, 0);
	
	operator.addAbonent(ab);
	operator.addAbonent(ba);
	
//	ab.tryMakeCall(ba);
	
	//ab.resuplyMoneyCommand(100);
	
	//ab.resuplyMoneyOtherUserCommand(50, "123678678");
	
	ab.sentSMSmessage("123678678");

	
	}

}
