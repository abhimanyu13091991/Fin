package com.fin.payment.fundtranfer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fin.payment.fundtranfer.entity.Account;

public interface FundTranferRepo extends JpaRepository<Account, String>{

}
