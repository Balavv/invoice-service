package com.usertransaction.service.controllers;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.usertransaction.service.model.TransactionDto;
import com.usertransaction.service.services.TransactionService;
import org.apache.commons.validator.routines.EmailValidator;

import lombok.RequiredArgsConstructor;

/**
 * Created by bs on 2020-03-08.
 */
@RequiredArgsConstructor
@RequestMapping("/api/v1/")
@RestController
public class UserTransactionController {

	private final TransactionService transactionService;

	@GetMapping(produces = { "application/json" }, path = "transaction/{email}")
	public ResponseEntity<List<TransactionDto>> listTransactions(
			@PathVariable(value = "email", required = false) String email) {
		
		   
		
		List<TransactionDto> transactionList = transactionService.listTransactions(email);

		return new ResponseEntity<>(transactionList, HttpStatus.OK);
		
	}

}
