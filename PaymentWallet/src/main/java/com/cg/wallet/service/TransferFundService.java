package com.cg.wallet.service;
import com.cg.wallet.dto.TransferFundDto;
import com.cg.wallet.exception.BalanceException;
import com.cg.wallet.exception.TransactionException;
import com.cg.wallet.exception.WalletNotFoundException;

public interface TransferFundService {

	public String transferFund(TransferFundDto tfDto) throws TransactionException,BalanceException,WalletNotFoundException;
	
}
