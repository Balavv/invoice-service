package com.usertransaction.service.model;

import java.util.List;

import javax.validation.constraints.Email;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.usertransaction.service.domain.Transaction;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


/**
 * Created by bs on 2020-03-08.
 */

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
	
	private Long id;
	@Email(message = "Email should be valid")
	private String email;
	private String firstName;
	private String lastName;
	@JsonIgnore
	private  List<Transaction> userTransaction;
}
