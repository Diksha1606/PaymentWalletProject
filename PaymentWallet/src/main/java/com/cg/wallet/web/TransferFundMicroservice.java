
package com.cg.wallet.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.wallet.dto.SuccessResponse;
import com.cg.wallet.dto.TransferFundDto;
import com.cg.wallet.exception.BalanceException;
import com.cg.wallet.exception.TransactionException;
import com.cg.wallet.exception.WalletNotFoundException;
import com.cg.wallet.service.TransferFundService;
import com.cg.wallet.util.TransferFundConstants;

@RestController
@CrossOrigin(origins= {"http://localhost:4200"})
public class  TransferFundMicroservice {
	
	@Autowired
	private TransferFundService tfService;

	@PostMapping(TransferFundConstants.TRANSFER_URL)
	public SuccessResponse transferFund(@RequestBody TransferFundDto tfDto) throws TransactionException,BalanceException,WalletNotFoundException
	{
		String message = tfService.transferFund(tfDto);
		return new SuccessResponse(message);
	}
}

