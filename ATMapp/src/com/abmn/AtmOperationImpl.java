package com.abmn;

import java.util.HashMap;
import java.util.Map;

public class AtmOperationImpl implements AtmOperationInterf {
    ATM atm=new ATM();
    Map<Double,String> ministmt=new HashMap<>();
	@Override
	public void viewBalance() {
		// TODO Auto-generated method stub
		System.out.println("Available Balance is : "+atm.getBalance());

	}

	@Override
	public void withdrawAmount(double withdrawAmount) {
		// TODO Auto-generated method stub

	}

	@Override
	public void depositAmount(double depositAmount) {
		// TODO Auto-generated method stub

	}

	@Override
	public void viewMiniStatement() {
		// TODO Auto-generated method stub

	}

}
