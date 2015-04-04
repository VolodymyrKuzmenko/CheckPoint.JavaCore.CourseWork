package com.checkpoint.javacore.coursework.abonent;


import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

import com.checkpoint.javacore.coursework.network.Position;
import com.checkpoint.javacore.coursework.networkoperator.NetworkOperator;
import com.checkpoint.javacore.coursework.networkoperator.packages.MobilePackage;

public class Abonent {
	private int id;
	private int number;
	private NetworkOperator myOperator;
	private PersonalAccaunt myAccaunt;
//	private Operations myOperations;
	private MobilePackage mobilePackage;
	private Position myCurrentPosition;
	private Scanner sc = new Scanner(System.in); 
	
	
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
	
	public Position getMyPosition(){
		return myCurrentPosition;
	}

	
	public MobilePackage getMobilePackage(){
		return this.mobilePackage;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getNumber(){
		return number;
	}
	public String sentPhoneCall(){
		return sc.nextLine();
	}
	
	public void resievePhoneCall(String meaage){
		System.out.println(number + ": " + meaage);
	}
	public void getCharge(long timeMiles, int idOperator){
		myAccaunt.transaction(mobilePackage.calculateCharge((int)timeMiles, id, idOperator));
	}
	
	public int getNetworkOperatorId(){
		return myOperator.getOperatorId();
	}
	
}
