package com.cg.bank.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bank.dao.BankAccountDao;
import com.cg.bank.dto.AccountForm;
import com.cg.bank.entity.BankAccount;
import com.cg.bank.exception.BankAccountException;
import com.cg.bank.util.BankConstants;

@Service
@Transactional
public class BankServiceImpl implements BankService {
	Logger log = LoggerFactory.getLogger(BankServiceImpl.class);
	@Autowired
	private BankAccountDao bankAccount;

	@Override
	public String verifyAccount(AccountForm form) throws BankAccountException {
		BankAccount acc = bankAccount.getAccount(form.getAccountId(), form.getPin(), form.getBankName());
		log.info(form.getAccountId());
		log.info(form.getPin());
		log.info(form.getBankName());

		if (acc == null) {
			throw new BankAccountException(BankConstants.INVALID_ACCOUNT);
		}
		log.info(BankConstants.VERIFY_RESULT);

		return BankConstants.VERIFY_RESULT;

	}

	@Override
	public String editAccount(String accountId, double amt) throws BankAccountException {
		Optional<BankAccount> opt = bankAccount.findById(accountId);
		if (!opt.isPresent()) {
			throw new BankAccountException(BankConstants.INVALID_ACCOUNT);
		}
		BankAccount account = opt.get();
		log.info(account.toString());
		if (account.getBalance() < amt) {
			throw new BankAccountException(BankConstants.INSUFFICIENT_BALANCE);
		}
		account.setBalance(account.getBalance() -amt);
		bankAccount.save(account);

		return BankConstants.EDITED;
	}

}
