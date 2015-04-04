package com.checkpoint.javacore.coursework.abonent.operations;

import com.checkpoint.javacore.coursework.abonent.Abonent;
import com.checkpoint.javacore.coursework.abonent.PersonalAccaunt;
import com.checkpoint.javacore.coursework.alertsystem.NetworkOperatorSender;
import com.checkpoint.javacore.coursework.networkoperator.NetworkOperator;
import com.checkpoint.javacore.coursework.networkoperator.operations.OperationResultCommand;

public class ResupplyMoneyCommand implements OperationCommand {
	private int resieverId;
	private int money;
	private NetworkOperatorSender sender;
	private Abonent abonent;

	public ResupplyMoneyCommand(Abonent abonent) {
		// TODO Auto-generated constructor stub
		this.abonent = abonent;
	}
	
	@Override
	public void run() {
		NetworkOperator operator = abonent.getNetworkOperator();
		PersonalAccaunt accaunt = operator.getAcauntById(abonent.getBalansId());
		accaunt.transaction(money);
		OperationResultCommand command =(OperationResultCommand) new OperationResultCommand(sender).addMessage("current balanse: "+ accaunt.getBalance()).setResiever(abonent);
		operator.getSender().singleSending(command);
	

	}

	@Override
	public int getResieverId() {
		return resieverId;
	}

	

	public ResupplyMoneyCommand addResieverValue(int valueAdd) {
		this.money = valueAdd;
		return this;
	}

	@Override
	public OperationCommand setResiever(Abonent abonent) {
		resieverId = abonent.getId();
		return this;
	}

}
