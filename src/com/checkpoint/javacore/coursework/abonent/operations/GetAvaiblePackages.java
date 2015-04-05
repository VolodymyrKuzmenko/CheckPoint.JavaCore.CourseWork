package com.checkpoint.javacore.coursework.abonent.operations;

import com.checkpoint.javacore.coursework.abonent.Abonent;
import com.checkpoint.javacore.coursework.networkoperator.NetworkOperator;
import com.checkpoint.javacore.coursework.networkoperator.operations.OperationResultCommand;
import com.checkpoint.javacore.coursework.networkoperator.packages.MobilePackage;

public class GetAvaiblePackages implements OperationCommand {

	private Abonent resiever;
	private Abonent sender;
	
	public GetAvaiblePackages(Abonent abonent) {
		this.sender = abonent;
	}
	
	@Override
	public void run() {
		NetworkOperator operator = sender.getNetworkOperator();
		String resultMessage = new String();
		for (MobilePackage packgs : operator.getAvaiblePackages()) {
			resultMessage+=packgs.getInformation().buildInformation();
			resultMessage+="\n";
		}
		OperationResultCommand command =(OperationResultCommand) new OperationResultCommand(operator.getSender()).addMessage("Avaible Packages:\n"+resultMessage).setResiever(sender);
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
