package com.fin.payment.fundtranfer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fin.payment.fundtranfer.entity.Account;
import com.fin.payment.fundtranfer.entity.AccountTransaction;
import com.fin.payment.fundtranfer.service.impl.FundTranferServiceImpl;

@RestController
@RequestMapping("/list/")
public class FundTransferController {
	
	@Autowired
	FundTranferServiceImpl fundTranferServiceImpl;

	@PostMapping("/balance/{account}")
	public Account getBalance(@PathVariable(name="account") String accnt) {
		
		Account response = (Account) fundTranferServiceImpl.getUserBalance(accnt);	
		return response;
	}
	
	@PostMapping("/transact/{frmAccount}/{toAccount}/{amount}")
	public AccountTransaction send(@PathVariable(name="frmAccount") String fAccnt,@PathVariable(name="toAccount") String tAccnt, @PathVariable(name="amount") int amt) {
		
		AccountTransaction response = fundTranferServiceImpl.sendTo(fAccnt, tAccnt, amt);	
		return response;
	}
	
	@PostMapping("/transaction/{frmAccount}")
	public List<AccountTransaction> getTransaction(@PathVariable(name="frmAccount") String fAccnt) {
		
		List<AccountTransaction> response = fundTranferServiceImpl.getUserTransaction(fAccnt);	
		return response;
	}
	
}
