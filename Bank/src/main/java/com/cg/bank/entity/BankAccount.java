package com.cg.bank.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="bank_account")
@DynamicUpdate
@DynamicInsert

public class BankAccount {
	
	
	@Id
	@Column(name="account_id")
	private String accountId;
	@Column(name="customer_name", length=25)
	private String custName;
	@Column(name="pin")
	private String pin;
	@Column(name="balance")
	private double balance;
	@Column(name="phone_no")
	private String phoneNo;
	@Column(name="bank_name", length = 15)
	private String bankName;
	
	public BankAccount() {
		super();
	}

	

	public String getAccountId() {
		return accountId;
	}



	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}



	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
}

