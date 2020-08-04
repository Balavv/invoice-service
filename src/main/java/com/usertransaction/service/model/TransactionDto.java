package com.usertransaction.service.model;

import java.sql.Timestamp;
import java.time.OffsetDateTime;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.usertransaction.service.domain.TransactionType;
import com.usertransaction.service.domain.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by bs on 2020-03-08.
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionDto {
	
	@JsonIgnore
	private Long id;
	private TransactionType transactionType;
	private OffsetDateTime createdDate;
	@JsonIgnore
	private User user;

}
