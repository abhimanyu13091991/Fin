package com.fin.payment.fundtranfer.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
public class AccountTransaction {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long transactionId;
	
	private String fromAccount;
	
	private String toAccount;
	private int depositAmount;
	
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
	public String getToAccount() {
		return toAccount;
	}
	public void setToAccount(String toAccount) {
		this.toAccount = toAccount;
	}
	public int getDepositAmount() {
		return depositAmount;
	}
	public void setDepositAmount(int depositAmount) {
		this.depositAmount = depositAmount;
	}
	
	
}
