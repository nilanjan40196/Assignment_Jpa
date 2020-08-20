package com.capg.Assignment_Jpa.service;

import java.util.List;

import com.capg.Assignment_Jpa.beans.Account;
import com.capg.Assignment_Jpa.beans.Loan;
import com.capg.Assignment_Jpa.beans.Transaction;

public interface IService {
	
	public boolean validateAccountId(String id);
	public boolean validateAccountName(String name);
	
	public void createAccount(Account acc);
	public void createAccountWithLoan(Loan loan);
	
	public Account getAccDetails(String accId);
	public Loan getLoanDetails(String accId);
	
	public double depositAmount(String accId,double amt);
	public double withdrawAmount(String accId,double amt);
	
	public double payLoan(String accId,double amt);
	public double getLoan(String loan,double a);
	
	public List<Transaction> getTransactionDetails(String accountId);
}
