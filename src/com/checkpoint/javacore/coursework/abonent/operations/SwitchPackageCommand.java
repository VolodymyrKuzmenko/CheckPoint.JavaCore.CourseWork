package com.checkpoint.javacore.coursework.abonent.operations;

import com.checkpoint.javacore.coursework.abonent.Abonent;
import com.checkpoint.javacore.coursework.networkoperator.NetworkOperator;
import com.checkpoint.javacore.coursework.networkoperator.operations.OperationResultCommand;
import com.checkpoint.javacore.coursework.networkoperator.packages.MobilePackage;

public class SwitchPackageCommand implements OperationCommand {

	private int packageIdNew;
	private Abonent resiever;
	private Abonent sender;
	
	public SwitchPackageCommand(Abonent sender) {
		this.sender = sender;
	}
	
	@Override
	public void run() {
		NetworkOperator operator = sender.getNetworkOperator();
		MobilePackage package1 = operator.getPakageById(packageIdNew); 
		sender.resetPackage(package1);
		OperationResultCommand command =(OperationResultCommand) new OperationResultCommand(operator.getSender()).addMessage("Mobile Pakage was reset, new package is "+package1.getName()).setResiever(sender);
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
	public SwitchPackageCommand setNewPakageId(int id){
		this.packageIdNew = id;
		return this;
	}


}
