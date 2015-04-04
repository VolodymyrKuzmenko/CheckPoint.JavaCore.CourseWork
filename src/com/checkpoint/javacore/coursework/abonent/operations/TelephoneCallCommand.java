package com.checkpoint.javacore.coursework.abonent.operations;

import com.checkpoint.javacore.coursework.abonent.Abonent;

public class TelephoneCallCommand implements OperationCommand {
	private Abonent sender;
	private Abonent resiver;
	@Override
	public void run() {
		sender.getCharge(0, resiver.getNetworkOperatorId());
		long time = System.currentTimeMillis();
		String message = null;
		do{
			 message= sender.sentPhoneCall();
			resiver.resievePhoneCall(message);
		}while (message!=null);
		time =  System.currentTimeMillis()- time;
		sender.getCharge(time, resiver.getNetworkOperatorId());
	}
	@Override
	public int getResieverId() {
		return resiver.getId();
	}
	
	public TelephoneCallCommand addResiever(Abonent abonent){
		resiver = abonent;
		return this;
	}
	public TelephoneCallCommand addSender(Abonent abonent){
		sender = abonent;
		return this;
	}
	
	
	
	

}
