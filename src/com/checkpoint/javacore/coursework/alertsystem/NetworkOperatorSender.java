package com.checkpoint.javacore.coursework.alertsystem;

import java.util.ArrayList;

import com.checkpoint.javacore.coursework.abonent.Abonent;
import com.checkpoint.javacore.coursework.abonent.operations.OperationCommand;
import com.checkpoint.javacore.coursework.networkoperator.NetworkOperator;

public class NetworkOperatorSender {
	private NetworkOperator operator;
	private ArrayList<Abonent> abonents;
	
	public NetworkOperatorSender(NetworkOperator operator, ArrayList<Abonent> abonents) {
		this.operator = operator;
		this.abonents = abonents;
	}
	
	public void singleSending(Abonent abonent, OperationCommand command){
		operator.getGround().makeTransaction(abonent,command);
	}
	
	public void multiSendingByPackage(int packageId, OperationCommand command){
		for (Abonent abonent : abonents) {
			if(abonent.getMobilePackage().getId()==packageId)
				this.singleSending(abonent, command);
		}
	}
	
	public void multiSendingByTariff(int tariffId, OperationCommand command){
		for (Abonent abonent : abonents) {
			if(abonent.getMobilePackage().isUseTariffById(tariffId))
				this.singleSending(abonent, command);
		}
	}
	
	public void multiSendingByDiscount(int discountId, OperationCommand command){
		for (Abonent abonent : abonents) {
			if(abonent.getMobilePackage().isUseDiscountById(discountId))
				this.singleSending(abonent, command);
		}
	}
	
	public void multiSendingByLicenseFee(int licenseFeeId, OperationCommand command){
		for (Abonent abonent : abonents) {
			if(abonent.getMobilePackage().isUseLicenseFeeById(licenseFeeId))
				this.singleSending(abonent, command);
		}
	}
}
