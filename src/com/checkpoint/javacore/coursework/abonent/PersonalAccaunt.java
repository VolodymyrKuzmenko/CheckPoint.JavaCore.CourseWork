package com.checkpoint.javacore.coursework.abonent;

public class PersonalAccaunt {
	private int balance;
	private int acauntId;

	public PersonalAccaunt(int balance, int acauntId) {
		this.balance = balance;
		this.acauntId = acauntId;
	}

	public void transaction(int value) {
		balance += value;
	}

	public boolean checkBalanse(int value) {
		if (balance + value < 0)
			return false;
		else
			return true;
	}
	
	public int getAcauntId(){
		return acauntId;
	}
}
