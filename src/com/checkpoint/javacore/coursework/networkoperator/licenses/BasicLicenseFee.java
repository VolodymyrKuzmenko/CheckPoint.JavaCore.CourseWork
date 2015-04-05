package com.checkpoint.javacore.coursework.networkoperator.licenses;

import com.checkpoint.javacore.coursework.abonent.AbonentInformation;
import com.checkpoint.javacore.coursework.abonent.Information;

public class BasicLicenseFee implements LicenseFee {
	private int value;
	private int id;
	private String name;
	
	public BasicLicenseFee(int value, int id, String name) {
		super();
		this.value = value;
		this.id = id;
		this.name = name;
	}

	@Override
	public int getLicenseFee() {
		
		return this.value;
	}

	@Override
	public LicenseFee resetLicenseFee(int newValue) {
		this.value = newValue;
		return this;
	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return this.id;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	@Override
	public Information getInformation() {
		return new AbonentInformation().addLicenseFeeInformation(name, value);
	}

}
