package com.capg.Assignment_Jpa.dao;

import java.util.List;

import com.capg.Assignment_Jpa.beans.Account;
import com.capg.Assignment_Jpa.beans.Loan;
import com.capg.Assignment_Jpa.beans.Transaction;

public interface IDao {
	
	public void createAccount(Account acc);
	public void createAccountWithLoan(Loan loan);
	
	public Account getAccDetails(String accId);
	public Loan getLoanDetails(String accId);
	
	public double depositAmount(String accId,double amt);
	public double withdrawAmount(String accId,double amt);
	
	public double payLoan(String accId,double amt);
	public double getLoan(String loanId,double am);
	
	public List<Transaction> getTransactionDetails(String accountId);
}
