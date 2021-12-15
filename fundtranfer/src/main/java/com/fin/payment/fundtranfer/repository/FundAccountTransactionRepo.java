package com.fin.payment.fundtranfer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fin.payment.fundtranfer.entity.AccountTransaction;

public interface FundAccountTransactionRepo extends JpaRepository<AccountTransaction, Long>{

	/*@Query("SELECT u FROM AccountTransaction u WHERE u.fromAccount = ?1")
	List<AccountTransaction> getUserTrans(String fromAccount);*/

}
