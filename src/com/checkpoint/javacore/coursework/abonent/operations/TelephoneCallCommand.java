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
			 message= sender.sentPhoneCall().trim();
			 if (message.contains("exit")){
				 break;
			 }else
			resiver.resievePhoneCall(message);
		}while (true);
		time =  System.currentTimeMillis()- time;
		int foreginKy =resiver.getNetworkOperatorId();
		if (foreginKy == sender.getNetworkOperatorId()){
			foreginKy =-1;
		}
		sender.getCharge(time, foreginKy );
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
