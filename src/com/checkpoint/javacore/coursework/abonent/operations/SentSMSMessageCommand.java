package com.checkpoint.javacore.coursework.abonent.operations;

import com.checkpoint.javacore.coursework.abonent.Abonent;
import com.checkpoint.javacore.coursework.networkoperator.NetworkOperator;

public class SentSMSMessageCommand implements OperationCommand {
	private Abonent resiever;
	private Abonent sender;
	private String message;
	private String resieverNumber;
	private int toNetwork=0;
	
	
	public SentSMSMessageCommand(Abonent sender, String message) {
		this.sender = sender;
		this.message = message;
	}
	
	
	@Override
	public void run() {
		if(toNetwork==0){
			NetworkOperator operator = sender.getNetworkOperator();
			resiever = operator.getSender().getAbonentByNumber(resieverNumber);
			operator.getGround().makeTransaction(resiever, this);
			toNetwork++;
		}else{
			resiever.resieveSMSMessage(message, sender.getNumber());
		}
		
	}

	@Override
	public int getResieverId() {
		return resiever.getId();
	}

	@Override
	public OperationCommand setResiever(Abonent abonent) {
		this.resiever = abonent;
		return this;
	}
	public SentSMSMessageCommand setNumberResiever(String number){
		this.resieverNumber = number;
		return this;
		
	}

	

	
}
