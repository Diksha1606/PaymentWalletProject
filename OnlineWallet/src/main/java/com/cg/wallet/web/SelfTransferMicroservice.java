package com.cg.wallet.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cg.wallet.dto.AccountForm;
import com.cg.wallet.dto.SuccessResponse;
import com.cg.wallet.exception.WalletNotFoundException;
import com.cg.wallet.service.SelfTransferService;
import com.cg.wallet.util.WalletConstants;

@RestController
@CrossOrigin
public class SelfTransferMicroservice {
	
	@Autowired
	private SelfTransferService service;
	@Autowired
	private RestTemplate rt;
	@PostMapping(WalletConstants.SELF_TRANSFER_URL)
	public SuccessResponse selfTransfer(@RequestBody AccountForm form) throws WalletNotFoundException {
		String editUrl = "http://localhost:8088/wallet/edit";
		String res1= rt.postForObject(editUrl, form, String.class);
		String msg = service.addAmountToWallet(form);
		return new SuccessResponse(msg);
		
		
	}

}
