package com.cg.bank.service;

import com.cg.bank.dto.AccountForm;
import com.cg.bank.entity.BankAccount;
import com.cg.bank.exception.BankAccountException;

public interface BankService {
	public String verifyAccount(AccountForm form) throws BankAccountException;
	public String editAccount(String accountId, double balance) throws BankAccountException;
	

}
