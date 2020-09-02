package com.cg.wallet.dto;

import java.time.LocalDate;

public class TransferFundDto {
	private String fromWalletId;
	private String toWalletId;
	private double amount;
	public String getFromWalletId() {
		return fromWalletId;
	}
	public void setFromWalletId(String fromWalletId) {
		this.fromWalletId = fromWalletId;
	}
	public String getToWalletId() {
		return toWalletId;
	}
	public void setToWalletId(String toWalletId) {
		this.toWalletId = toWalletId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
}
