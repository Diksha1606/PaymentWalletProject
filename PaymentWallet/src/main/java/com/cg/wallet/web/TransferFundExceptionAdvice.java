package com.cg.wallet.web;

import java.time.LocalDateTime;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.wallet.dto.ErrorResponse;
import com.cg.wallet.exception.WalletNotFoundException;
import com.cg.wallet.exception.BalanceException;
import com.cg.wallet.exception.TransactionException;
import com.cg.wallet.util.TransferFundConstants;

@RestControllerAdvice
public class TransferFundExceptionAdvice {

	@ExceptionHandler(WalletNotFoundException.class)
	@ResponseStatus(code=HttpStatus.NOT_FOUND)
	public ErrorResponse handleWalletNotFoundException(WalletNotFoundException ex){
		return new ErrorResponse(HttpStatus.NOT_FOUND.toString(), ex.getMessage(),LocalDateTime.now().toString());
	}
		
	@ExceptionHandler(BalanceException.class)
	@ResponseStatus(code=HttpStatus.BAD_REQUEST, reason=TransferFundConstants.INSUFFICIENT_BALANCE)
	public ErrorResponse handleBalanceException(BalanceException ex) {
		return new ErrorResponse(HttpStatus.BAD_REQUEST.toString(), ex.getMessage(),LocalDateTime.now().toString());
	}
	
	

	@ExceptionHandler( TransactionException.class)
	@ResponseStatus(code=HttpStatus.BAD_REQUEST, reason=TransferFundConstants.IN_ACTIVE_USER)
	public ErrorResponse handleTransactionException( TransactionException ex) {
		return new ErrorResponse(HttpStatus.BAD_REQUEST.toString(), ex.getMessage(),LocalDateTime.now().toString());
	}
}
