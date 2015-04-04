package com.checkpoint.javacore.coursework.abonent.operations;

import com.checkpoint.javacore.coursework.abonent.Abonent;
import com.checkpoint.javacore.coursework.alertsystem.NetworkOperatorSender;
import com.checkpoint.javacore.coursework.networkoperator.NetworkOperator;
import com.checkpoint.javacore.coursework.networkoperator.operations.OperationResultCommand;

public class ResupplyOtherMoneyCommand implements OperationCommand {
	private Abonent sender;
	private NetworkOperatorSender resiever;
	private String otherAbonentNumber;
	private int value;
	
	public ResupplyOtherMoneyCommand(Abonent abonent, String phoneNumber, int value)  {
		this.sender = abonent;
		this.otherAbonentNumber = phoneNumber;
		this.value = value;
	}
	
	@Override
	public void run() {
		NetworkOperator operator = sender.getNetworkOperator();
		Abonent otherAbonent = resiever.getAbonentByNumber(otherAbonentNumber);
		otherAbonent.resuplyMoneyCommand(value);
		
		OperationResultCommand commandOthreUser =(OperationResultCommand) new OperationResultCommand(resiever).addMessage(sender.getNumber()+" sent you: "+ value).setResiever(otherAbonent);
		operator.getSender().singleSending(commandOthreUser);
		sender.resuplyMoneyCommand(value*-1);
		OperationResultCommand commandToSender =(OperationResultCommand) new OperationResultCommand(resiever).addMessage("Operation Complete. You send " +value + "to "+otherAbonentNumber).setResiever(sender);
		operator.getSender().singleSending(commandToSender);
		
	}

	@Override
	public int getResieverId() {
		return resiever.getNetworkOperatorId();
	}

	@Override
	public OperationCommand setResiever(Abonent abonent) {
		resiever = (NetworkOperatorSender) abonent;
		return this;
	}


	

}
