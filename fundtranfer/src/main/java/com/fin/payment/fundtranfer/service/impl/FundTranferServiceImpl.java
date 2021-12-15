package com.fin.payment.fundtranfer.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fin.payment.fundtranfer.entity.Account;
import com.fin.payment.fundtranfer.entity.AccountTransaction;
import com.fin.payment.fundtranfer.repository.FundAccountTransactionRepo;
import com.fin.payment.fundtranfer.repository.FundTranferRepo;

@Service
public class FundTranferServiceImpl implements FundTranferService{

	@Autowired
	FundTranferRepo fundTranferRepo;
	
	@Autowired
	FundAccountTransactionRepo fundAccountTransactionRepo;
	
	@Override
	public Account getUserBalance(String usr) {
		
		return fundTranferRepo.findById(usr).get();
	}

	public AccountTransaction sendTo(String fUser, String tUser, int amt) {
		
		AccountTransaction accountTrans = new AccountTransaction();
		accountTrans.setFromAccount(fUser);
		accountTrans.setToAccount(tUser);
		accountTrans.setDepositAmount(amt);
		AccountTransaction response = fundAccountTransactionRepo.save(accountTrans);
		
		if(response != null) {
			Account frmAccount = fundTranferRepo.findById(fUser).get();
			int famount  = frmAccount.getAmount();
			int totalamtwith = famount - amt;
			frmAccount.setAmount(totalamtwith);
			fundTranferRepo.save(frmAccount);
			
			Account toAccount = fundTranferRepo.findById(tUser).get();
			int tamount  = toAccount.getAmount();
			int totalamtdepo = tamount + amt;
			toAccount.setAmount(totalamtdepo);
			fundTranferRepo.save(toAccount);
		}
		return response;
	}

	public List<AccountTransaction> getUserTransaction(String fUser) {
		
		List<AccountTransaction>  list = fundAccountTransactionRepo.findAll();
		List<AccountTransaction> response = list.stream().filter(x->x.getFromAccount().equals(fUser)).collect(Collectors.toList());
		return response;
	}

}
