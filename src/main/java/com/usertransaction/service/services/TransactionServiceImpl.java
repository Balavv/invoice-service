package com.usertransaction.service.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.validator.EmailValidator;
import org.springframework.stereotype.Service;

import com.usertransaction.service.repositories.TransactionRepositoy;
import com.usertransaction.service.controllers.NotFoundException;
import com.usertransaction.service.domain.Transaction;
import com.usertransaction.service.mappers.TransactionMapper;
import com.usertransaction.service.model.TransactionDto;

/**
 * Created by bs on 2020-03-08.
 */

@Service
public class TransactionServiceImpl implements TransactionService {

	private final TransactionRepositoy transactionRepo;
	private final TransactionMapper transactionMapper;

	public TransactionServiceImpl(TransactionRepositoy transactionRepo,
			TransactionMapper transactionMapper) {
		this.transactionRepo =transactionRepo;
		this.transactionMapper = transactionMapper;
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<TransactionDto> listTransactions(String email) {

		
		List<Transaction> transactionList= new ArrayList<>();
		boolean valid = EmailValidator.getInstance().isValid(email);
		
		if(valid) {
		
		transactionList = transactionRepo.findAllbyEmail(email);
		return transactionList.stream()
				             .map(transactionMapper::transactionToTransactionDto)
				             .collect(Collectors.toList());

	}
		
		 throw new NotFoundException();

}
	
}
