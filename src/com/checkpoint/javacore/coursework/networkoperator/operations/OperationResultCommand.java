package com.checkpoint.javacore.coursework.networkoperator.operations;

import com.checkpoint.javacore.coursework.abonent.Abonent;
import com.checkpoint.javacore.coursework.abonent.operations.OperationCommand;
import com.checkpoint.javacore.coursework.alertsystem.NetworkOperatorSender;

public class OperationResultCommand implements OperationCommand {

	private Abonent resiever;
	private String message;
	private NetworkOperatorSender sender;
	
	@Override
	public void run() {
		resiever.receiveMessageFromOperator(message);

	}

	@Override
	public int getResieverId() {
		return resiever.getId();
	}
	
	public OperationResultCommand addMessage(String message){
		this.message = message;
		return this;
	}
	
	public OperationResultCommand (NetworkOperatorSender sender){
		this.sender = sender;
	}

	@Override
	public OperationCommand setResiever(Abonent abonent) {
		this.resiever = abonent;
		return this;
	}

}
