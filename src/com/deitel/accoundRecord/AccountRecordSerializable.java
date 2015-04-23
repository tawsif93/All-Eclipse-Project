package com.deitel.accoundRecord;

import java.io.Serializable;

@SuppressWarnings("serial")
public class AccountRecordSerializable implements Serializable{

	private int account ;
	private String firstName ;
	private String lastName ;
	private double balance ;
	
	public AccountRecordSerializable()
	{
		this( 0 , ""  ,"" , 0.0);
	}
	
	public AccountRecordSerializable( int acc , String first , String last , double bal)
	{
		this.account = acc ;
		this.firstName = first ;
		this.lastName = last ;
		this.balance = bal ;
	}

	public int getAccount() {
		return account;
	}

	public void setAccount(int account) {
		this.account = account;
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
