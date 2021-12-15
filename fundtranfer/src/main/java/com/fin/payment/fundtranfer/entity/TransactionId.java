package com.fin.payment.fundtranfer.entity;

import java.io.Serializable;

public class TransactionId implements Serializable{

	private long transactionId;
	
	private String fromAccount;

	public TransactionId(long transactionId, String fromAccount) {
		super();
		this.transactionId = transactionId;
		this.fromAccount = fromAccount;
	}

	public long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}

	public String getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(String fromAccount) {
		this.fromAccount = fromAccount;
	}

	
	
	
}
