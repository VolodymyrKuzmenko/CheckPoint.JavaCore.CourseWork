package com.checkpoint.javacore.coursework.abonent.operations;

import com.checkpoint.javacore.coursework.abonent.Abonent;
import com.checkpoint.javacore.coursework.networkoperator.NetworkOperator;
import com.checkpoint.javacore.coursework.networkoperator.operations.OperationResultCommand;

public class MyMobilePackageInformationCommand implements OperationCommand {
	private Abonent resiever;
	private Abonent sender;
	
	public MyMobilePackageInformationCommand(Abonent sender) {
		this.sender = sender;
	}
	
	@Override
	public void run() {
		NetworkOperator operator = sender.getNetworkOperator();
		String information = sender.getMobilePackage().getInformation().buildInformation();
		OperationResultCommand command =(OperationResultCommand) new OperationResultCommand(operator.getSender()).addMessage("Abonent information:\n"+information).setResiever(sender);
		operator.getSender().singleSending(command);
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
	
	

	

}
