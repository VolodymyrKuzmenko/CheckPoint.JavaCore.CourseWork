package com.checkpoint.javacore.coursework.abonent;

import java.util.Scanner;

import com.checkpoint.javacore.coursework.abonent.operations.GetAvaiblePackages;
import com.checkpoint.javacore.coursework.abonent.operations.MyMobilePackageInformationCommand;
import com.checkpoint.javacore.coursework.abonent.operations.ResupplyMoneyCommand;
import com.checkpoint.javacore.coursework.abonent.operations.ResupplyOtherMoneyCommand;
import com.checkpoint.javacore.coursework.abonent.operations.SentSMSMessageCommand;
import com.checkpoint.javacore.coursework.abonent.operations.SwitchPackageCommand;
import com.checkpoint.javacore.coursework.abonent.operations.TelephoneCallCommand;
import com.checkpoint.javacore.coursework.network.Ground;
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
	private Ground ground;
	private int newPackageId;
	
	
	public Abonent(Ground ground, int id) {
		this.ground = ground;
		this.id = id;
	}
	
	public Abonent linkNumber(String number){
		this.number = Integer.parseInt(myOperator.getOperatorNumberCode()+number.replaceAll("[+()-]", ""));
		return this;
	}
	
	public Abonent linkOperator(NetworkOperator operator){
		this.myOperator = operator;
		return this;
	}
	
	public Abonent linkMobilePackage(MobilePackage package1){
		this.mobilePackage = package1;
		return this;
	}
	public Abonent linkPersonalAcaunt(int balance, int id){
		this.myAccaunt = new PersonalAccaunt(balance, id);
		myOperator.addPersonalAccaunt(myAccaunt);
		return this;
	}
	
	public Abonent linkAbonentPosition(int x, int y){
		myCurrentPosition = new Position(x, y);
		return this;
	}
	public int getBalans(){
		return myAccaunt.getBalance();
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

	public void tryMakeCall(Abonent resiever) {
		ground.makeTransaction(this, new TelephoneCallCommand().addSender(this).setResiever(resiever));
	}
	
	public void resuplyMoneyCommand(int value){
		ground.makeTransaction(this, new ResupplyMoneyCommand(this).addResieverValue(value).setResiever(myOperator.getSender()));
	}
	
	public void resuplyMoneyOtherUserCommand(int value, String number){
		ground.makeTransaction(this, new ResupplyOtherMoneyCommand(this, number, value).setResiever(myOperator.getSender()));
	}
	
	public void resievePhoneCall(String meaage){
		System.out.println(number + " says: " + new StringBuilder(meaage).reverse());
	}
	public void getCharge(long timeMiles, int idOperator){
		
		myAccaunt.transaction(mobilePackage.calculateCharge((int)timeMiles, id, idOperator));
	}
	
	public void resetPackage(MobilePackage newPakage){
		this.mobilePackage = newPakage;
	}
	
	public void sentSMSmessage(String numberResiever){
		String s = "simple sms masege form "+ Integer.toString(number); 
		ground.makeTransaction(this, new SentSMSMessageCommand(this, s).setNumberResiever(numberResiever).setResiever(myOperator.getSender()));
	}
	
	public void receiveMessageFromOperator(String text){
		System.out.println("Operator to "+number+ ": "+ text);
	}
	
	public void resieveSMSMessage(String text, int fromNumber){
		System.out.println(fromNumber +" to "+number+ ": "+ text);
		
	}
	public void swithchPackage(int id){
		newPackageId = id;
		ground.makeTransaction(this, new SwitchPackageCommand(this).setNewPakageId(newPackageId).setResiever(myOperator.getSender()));
	}
	
	public int getNetworkOperatorId(){
		return myOperator.getOperatorId();
	}
	
	public NetworkOperator getNetworkOperator(){
		return myOperator;
	}
	public void getMyInformation(){
		ground.makeTransaction(this, new MyMobilePackageInformationCommand(this).setResiever(myOperator.getSender()));
	}
	public void getAvaiblePackages(){
		ground.makeTransaction(this, new GetAvaiblePackages(this).setResiever(myOperator.getSender()));
	}
	public int getBalansId(){
		return myAccaunt.getAcauntId();
	}
	 public void decreaseMoney(int value){
		 myAccaunt.transaction(value*-1);
	 }
	 public boolean checkMyBalanse(int value){
		 return myAccaunt.checkBalanse(value*-1);
	 }
	 
	
}
