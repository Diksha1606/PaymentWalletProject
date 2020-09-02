package com.cg.bank.web;

import java.time.LocalDateTime;

import javax.websocket.ClientEndpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.bank.dto.AccountForm;
import com.cg.bank.dto.ErrorResponse;
import com.cg.bank.entity.BankAccount;
import com.cg.bank.exception.BankAccountException;
import com.cg.bank.service.BankService;
import com.cg.bank.service.BankServiceImpl;
import com.cg.bank.util.BankConstants;


@RestController
public class BankAccountMicroservice {
	
	@Autowired
	private BankService service;
	
	@PostMapping(BankConstants.VERIFY_URL)
	public String getAccount(@RequestBody AccountForm form) throws BankAccountException {
		return service.verifyAccount(form) ;
	}
	
	@PostMapping(BankConstants.EDIT_URL)
	public String editAccount(@RequestBody AccountForm form) throws BankAccountException {
		return service.editAccount(form.getAccountId(), form.getBalance()) ;
	}
	
	@ExceptionHandler(BankAccountException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public ErrorResponse handleAccountException(BankAccountException ex) {
		return new ErrorResponse(HttpStatus.NOT_FOUND.toString(), BankConstants.INVALID_ACCOUNT, LocalDateTime.now().toString());
	}
	

}
