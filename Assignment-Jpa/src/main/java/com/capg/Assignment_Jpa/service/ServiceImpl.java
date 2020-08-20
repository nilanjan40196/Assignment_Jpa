package com.capg.Assignment_Jpa.service;

import java.util.List;

import com.capg.Assignment_Jpa.beans.Account;
import com.capg.Assignment_Jpa.beans.Loan;
import com.capg.Assignment_Jpa.beans.Transaction;
import com.capg.Assignment_Jpa.dao.DaoImpl;
import com.capg.Assignment_Jpa.dao.IDao;

public class ServiceImpl implements IService{
	
	IDao dao;
	
	public ServiceImpl() {
		dao = new DaoImpl();
	}
	
	@Override
	public boolean validateAccountId(String id) {
		String regexId = "^[0-9]{7}[A-Za-z]{4}$";
		return id.matches(regexId);
	}

	@Override
	public boolean validateAccountName(String name) {
		String regexName = "^[A-Z]{1}[a-z]{2,30}$";
		return name.matches(regexName);
	}

	@Override
	public void createAccount(Account acc) {
		// TODO Auto-generated method stub
		
		dao.createAccount(acc);
		
	}

	@Override
	public void createAccountWithLoan(Loan loan) {
		// TODO Auto-generated method stub
		
		dao.createAccountWithLoan(loan);
		
	}

	@Override
	public Account getAccDetails(String accId) {
		// TODO Auto-generated method stub
		return dao.getAccDetails(accId);
	}

	@Override
	public Loan getLoanDetails(String accId) {
		// TODO Auto-generated method stub
		return dao.getLoanDetails(accId);
	}

	@Override
	public double depositAmount(String accId, double amt) {
		// TODO Auto-generated method stub
		return dao.depositAmount(accId, amt);
	}

	@Override
	public double withdrawAmount(String accId, double amt) {
		// TODO Auto-generated method stub
		return dao.withdrawAmount(accId, amt);
	}

	@Override
	public double payLoan(String accId,double amt) {
		// TODO Auto-generated method stub
		
		return dao.payLoan(accId, amt);
	}

	@Override
	public double getLoan(String loanId, double a) {
		// TODO Auto-generated method stub
		
		return dao.getLoan(loanId, a);
	}

	@Override
	public List<Transaction> getTransactionDetails(String accountId) {
		// TODO Auto-generated method stub
		return dao.getTransactionDetails(accountId);
	}

}
