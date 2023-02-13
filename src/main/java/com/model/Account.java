package com.model;

public class Account {
	private int accountID;
	private String accountType;
	private String customerName;
	
	@Override
	public String toString() {
		return "Account [accountID=" + accountID + ","
				+ " accountType=" + accountType + ", customerName=" + customerName
				+ "]";
	}
	
	

	
	public Account(int accountID, String accountType, String customerName) {
		super();
		this.accountID = accountID;
		this.accountType = accountType;
		this.customerName = customerName;
	}
	
	public int getAccountID() {
		return accountID;
	}
	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	
}
