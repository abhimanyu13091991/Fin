package com.fin.payment.fundtranfer.service.impl;

import com.fin.payment.fundtranfer.entity.Account;

public interface FundTranferService {

	Account getUserBalance(String usr);
}
