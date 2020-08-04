package com.usertransaction.service.services;

import java.util.List;

import com.usertransaction.service.model.TransactionDto;

/**
 * Created by bs on 2020-03-08.
 */
public interface TransactionService {
	
	List<TransactionDto>  listTransactions(String email);

}
