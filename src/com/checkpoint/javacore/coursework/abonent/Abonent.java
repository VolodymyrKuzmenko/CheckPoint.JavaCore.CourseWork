package com.checkpoint.javacore.coursework.abonent;


import com.checkpoint.javacore.coursework.network.Position;
import com.checkpoint.javacore.coursework.networkoperator.NetworkOperator;
import com.checkpoint.javacore.coursework.networkoperator.packages.MobilePackage;

public class Abonent {
	private int number;
	private NetworkOperator myOperator;
	private PersonalAccaunt myAccaunt = new PersonalAccaunt();
//	private Operations myOperations;
	private MobilePackage mobilePackage;
	private Position myCurrentPosition;
	
	public Abonent linkNumber(String number){
		this.number = Integer.parseInt(number.replaceAll("[+()-]", ""));
		return this;
	}
	
	public Abonent linkOperator(NetworkOperator operator){
		this.myOperator = operator;
		number = Integer.parseInt(myOperator.getOperatorNumberCode().concat(Integer.toString(number)));
		return this;
	}
	
	public Abonent linkMobilePackage(MobilePackage package1){
		this.mobilePackage = package1;
		return this;
	}
}
