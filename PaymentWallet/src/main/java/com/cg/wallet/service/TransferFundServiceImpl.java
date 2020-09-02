
package com.cg.wallet.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.wallet.dao.WalletAccountDao;
import com.cg.wallet.dao.WalletTransactionDao;
import com.cg.wallet.dto.TransferFundDto;
import com.cg.wallet.entity.WalletAccount;
import com.cg.wallet.entity.WalletTransaction;
import com.cg.wallet.exception.WalletNotFoundException;
import com.cg.wallet.exception.TransactionException;
import com.cg.wallet.exception.BalanceException;
import com.cg.wallet.util.TransferFundConstants;


@Service("TransferFundService")
public class TransferFundServiceImpl implements TransferFundService{

	@Autowired
	private WalletAccountDao accountDao;
	
	@Autowired
	private WalletTransactionDao txnDao;

	@Override
	@Transactional
	public String transferFund(TransferFundDto tfDto) throws TransactionException,BalanceException,WalletNotFoundException{
	Optional<WalletAccount> optfromWalletAccount =accountDao.findById(tfDto.getFromWalletId());
	if(!optfromWalletAccount.isPresent())
		throw new WalletNotFoundException(TransferFundConstants.INVALID_WALLET_ACCOUNT + tfDto.getFromWalletId());
	
	Optional<WalletAccount> opttoWalletAccount =accountDao.findById(tfDto.getToWalletId());
	if(!opttoWalletAccount.isPresent())
		throw new WalletNotFoundException(TransferFundConstants.INVALID_WALLET_ACCOUNT + tfDto.getToWalletId());
	
	WalletAccount fromAcc = optfromWalletAccount.get();
	WalletAccount toAcc = opttoWalletAccount.get();
	
	if(fromAcc.getStatus().equals(TransferFundConstants.IN_ACTIVE_USER)) 
		throw new TransactionException(tfDto.getFromWalletId() + TransferFundConstants.IN_ACTIVE_MSG);
	
	if(toAcc.getStatus().equals(TransferFundConstants.IN_ACTIVE_USER)) 
		throw new TransactionException(tfDto.getToWalletId() + TransferFundConstants.IN_ACTIVE_MSG);
	
	if(fromAcc.getBalance() < tfDto.getAmount())
		throw new BalanceException(TransferFundConstants.INSUFFICIENT_BALANCE);
	
	fromAcc.setBalance(fromAcc.getBalance() - tfDto.getAmount());
	toAcc.setBalance(toAcc.getBalance() + tfDto.getAmount());
	accountDao.save(fromAcc);
	accountDao.save(toAcc);
	
	WalletTransaction txFrom = new WalletTransaction();
	txFrom.setAmount(tfDto.getAmount());
	txFrom.setDateOfTransaction(LocalDate.now());
	txFrom.setTxType(TransferFundConstants.DEBIT);
	txFrom.setDescription(TransferFundConstants.TRANSFER_FROM_DESC + tfDto.getFromWalletId());
	txFrom.setAccount(fromAcc);
	txnDao.save(txFrom);
	
	WalletTransaction txTo = new WalletTransaction();
	txTo.setAmount(tfDto.getAmount());
	txTo.setDateOfTransaction(LocalDate.now());
	txTo.setTxType(TransferFundConstants.CREDIT);
	txTo.setDescription(TransferFundConstants.TRANSFER_TO_DESC + tfDto.getToWalletId());
	txTo.setAccount(toAcc);
	txnDao.save(txTo);
	
		return TransferFundConstants.TRANSFERRED;
	}
	
}














