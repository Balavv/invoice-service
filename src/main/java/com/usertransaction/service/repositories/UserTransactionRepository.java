package com.usertransaction.service.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.usertransaction.service.domain.User;

/**
 * Created by bs on 2020-03-08.
 */

public interface UserTransactionRepository extends PagingAndSortingRepository<User, Long> {
	
	Page<User> findAllByEmail(@Param("email") String email, Pageable pageable);
	

}
