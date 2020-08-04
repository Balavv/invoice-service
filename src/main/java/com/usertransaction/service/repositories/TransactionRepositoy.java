package com.usertransaction.service.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.usertransaction.service.domain.Transaction;

/**
 * Created by bs on 2020-03-08.
 */

public interface TransactionRepositoy extends CrudRepository<Transaction, Long> {
	
	@Query(value = "SELECT * FROM Transaction t, User_Transaction u WHERE u.email = ?1",nativeQuery = true)
	 List<Transaction> findAllbyEmail( String email);
	
}
