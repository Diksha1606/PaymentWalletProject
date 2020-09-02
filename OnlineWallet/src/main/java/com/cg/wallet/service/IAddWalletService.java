package com.cg.wallet.service;

import com.cg.wallet.dto.AccountForm;
import com.cg.wallet.dto.UserDto;
import com.cg.wallet.exception.BankAccountException;
import com.cg.wallet.exception.WalletAccountExistsException;

public interface IAddWalletService {
	
	
	public String addNewWalletAccount(UserDto userDto) throws WalletAccountExistsException;
	public String addBankAccount(AccountForm form) throws BankAccountException, WalletAccountExistsException ;
}
