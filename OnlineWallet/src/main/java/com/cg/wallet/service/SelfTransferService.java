package com.cg.wallet.service;

import com.cg.wallet.dto.AccountForm;
import com.cg.wallet.exception.WalletNotFoundException;

public interface SelfTransferService {
	public String addAmountToWallet(AccountForm form) throws WalletNotFoundException;

}
