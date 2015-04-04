package com.checkpoint.javacore.coursework.alertsystem;

import java.util.ArrayList;

import com.checkpoint.javacore.coursework.abonent.Abonent;
import com.checkpoint.javacore.coursework.abonent.operations.OperationCommand;
import com.checkpoint.javacore.coursework.network.Ground;
import com.checkpoint.javacore.coursework.network.NetworkTower;
import com.checkpoint.javacore.coursework.network.Position;
import com.checkpoint.javacore.coursework.networkoperator.NetworkOperator;

public class NetworkOperatorSender extends Abonent{
	private NetworkOperator operator;
	private ArrayList<Abonent> abonents;
	
	public NetworkOperatorSender(NetworkOperator operator, ArrayList<Abonent> abonents, Ground ground, NetworkTower mainTower) {
		super(ground, operator.getOperatorId());
		Position p = mainTower.getMyPosition();
		super.linkAbonentPosition((int)p.x, (int)p.y);
		this.operator = operator;
		this.abonents = abonents;
	}
	
	public void singleSending(OperationCommand command){
		operator.getGround().makeTransaction(this,command);
	}
	
	public void multiSendingByPackage(int packageId, OperationCommand command){
		for (Abonent abonent : abonents) {
			if(abonent.getMobilePackage().getId()==packageId)
				this.singleSending(command);
		}
	}
	
	public void multiSendingByTariff(int tariffId, OperationCommand command){
		for (Abonent abonent : abonents) {
			if(abonent.getMobilePackage().isUseTariffById(tariffId))
				this.singleSending(command);
		}
	}
	
	public void multiSendingByDiscount(int discountId, OperationCommand command){
		for (Abonent abonent : abonents) {
			if(abonent.getMobilePackage().isUseDiscountById(discountId))
				this.singleSending(command);
		}
	}
	
	public void multiSendingByLicenseFee(int licenseFeeId, OperationCommand command){
		for (Abonent abonent : abonents) {
			if(abonent.getMobilePackage().isUseLicenseFeeById(licenseFeeId))
				this.singleSending(command);
		}
	}
}
