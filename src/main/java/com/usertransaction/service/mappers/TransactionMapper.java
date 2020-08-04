package com.usertransaction.service.mappers;

import org.mapstruct.Mapper;

import com.usertransaction.service.domain.Transaction;
import com.usertransaction.service.model.TransactionDto;

@Mapper(uses = {DateMapper.class})
public interface TransactionMapper {
	
	Transaction transactionDtoToTransaction(TransactionDto transactionDto);

	TransactionDto transactionToTransactionDto(Transaction transaction);

}
