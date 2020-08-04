package com.usertransaction.service.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
@Entity
@Table(name="Transaction")
public class Transaction {
	
	@Id
	@GeneratedValue
	private Long id;
	@Enumerated(EnumType.STRING)
	private TransactionType transactionType;
	@CreationTimestamp
	@Column(updatable = false)
	private Timestamp createdDate;
	
	@ManyToOne
	@JoinColumn(name="user_transaction_id",nullable = false)
	private User user;

}
