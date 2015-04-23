package com.deitel.accoundRecord;

public class AccountRecord {

	private int accont ;
	private String firstName , lastName ;
	private double balance ;
	
	public AccountRecord()
	{
		this (0 , "" , "" , 0.0);
	}
	
	public AccountRecord(int acct , String first , String last , double bal)
	{
		accont = acct;
		firstName = first ;
		lastName = last ;
		balance = bal ;
	}

	public int getAccont() {
		return accont;
	}

	public void setAccont(int accont) {
		this.accont = accont;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
}
