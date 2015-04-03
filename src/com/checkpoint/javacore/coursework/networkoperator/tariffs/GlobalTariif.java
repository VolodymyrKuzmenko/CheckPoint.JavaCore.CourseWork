package com.checkpoint.javacore.coursework.networkoperator.tariffs;

import java.util.ArrayList;

import com.checkpoint.javacore.coursework.networkoperator.NetworkOperator;
import com.checkpoint.javacore.coursework.networkoperator.licenses.LicenseFee;

public class GlobalTariif extends GeneralTariff {
	private ArrayList<NetworkOperator> operators;
	
	public GlobalTariif(LicenseFee globalLicenseFee, ArrayList<NetworkOperator> operators) {
		super();
		this.operators = operators;
		setLicenseFee(globalLicenseFee);
	}
	
}
