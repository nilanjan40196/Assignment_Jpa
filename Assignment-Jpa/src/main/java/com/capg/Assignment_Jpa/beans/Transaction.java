package com.capg.Assignment_Jpa.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;



@Entity
//@NamedQuery(name = "trxn",query = "select t from transaction t")
public class Transaction {
	
	@Id
	@Column(name = "tranId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transactionId;
	@ManyToOne
	private Account accountId;
	private double transactionAmt;
	@Enumerated(EnumType.STRING)
	private TransactionType transactionType;
	public int getTransactionId() {
		return transactionId;
	}
//	public void setTransactionId(int transactionId) {
//		this.transactionId = transactionId;
//	}
	public Account getAccountId() {
		return accountId;
	}
	public void setAccountId(Account accountId) {
		this.accountId = accountId;
	}
	public double getTransactionAmt() {
		return transactionAmt;
	}
	public void setTransactionAmt(double transactionAmt) {
		this.transactionAmt = transactionAmt;
	}
	public TransactionType getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}
	public Transaction( Account accountId, double transactionAmt, TransactionType transactionType) {
		super();
		
		this.accountId = accountId;
		this.transactionAmt = transactionAmt;
		this.transactionType = transactionType;
	}
	public Transaction() {
		super();
	}
	
	
	
	
	

}
