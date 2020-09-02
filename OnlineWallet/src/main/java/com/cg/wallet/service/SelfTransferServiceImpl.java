package com.cg.wallet.service;

import java.time.LocalDate;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.wallet.dao.WalletAccountDao;
import com.cg.wallet.dao.WalletTransactionDao;
import com.cg.wallet.dto.AccountForm;
import com.cg.wallet.entity.WalletAccount;
import com.cg.wallet.entity.WalletTransaction;
import com.cg.wallet.exception.WalletAccountExistsException;
import com.cg.wallet.exception.WalletNotFoundException;
import com.cg.wallet.util.WalletConstants;

@Service
@Transactional
public class SelfTransferServiceImpl implements SelfTransferService {

	@Autowired
	private WalletAccountDao wallAccdao;
	@Autowired
	private WalletTransactionDao txDao;
	@Override
	public String addAmountToWallet(AccountForm form) throws WalletNotFoundException {
		Optional<WalletAccount> optAccount = wallAccdao.findById(form.getPhoneNo());
		 if (!optAccount.isPresent())
			 throw new WalletNotFoundException(WalletConstants.INVALID_WALLET);
		 WalletAccount acc = optAccount.get();
		 acc.setBalance(acc.getBalance()+ form.getBalance());
		 wallAccdao.save(acc);
		 WalletTransaction tx = new WalletTransaction();
			tx.setAmount(form.getBalance());
			tx.setDateOfTranscation(LocalDate.now());
			tx.setTxType(WalletConstants.CREDIT);
			tx.setDescription(WalletConstants.AMOUNT_ADDED);
			txDao.save(tx);
		 
		return WalletConstants.AMOUNT_ADDED;
	}

}
