package com.capg.Assignment_Jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.capg.Assignment_Jpa.beans.Account;
import com.capg.Assignment_Jpa.beans.Loan;
import com.capg.Assignment_Jpa.beans.Transaction;
import com.capg.Assignment_Jpa.beans.TransactionType;

public class DaoImpl implements IDao{
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Jpa-Demo");
	private static EntityManager em = emf.createEntityManager();

	@Override
	public void createAccount(Account acc) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		em.persist(acc);
		em.getTransaction().commit();
		
	}

	@Override
	public void createAccountWithLoan(Loan loan) {
		// TODO Auto-generated method stub
		
		em.getTransaction().begin();
		em.persist(loan);
		em.getTransaction().commit();
		
	}

	@Override
	public Account getAccDetails(String accId) {
		// TODO Auto-generated method stub
		
		return em.find(Account.class, accId);
	}

	@Override
	public Loan getLoanDetails(String accId) {
		// TODO Auto-generated method stub
		
		return em.find(Loan.class, accId);
	}

	@Override
	public double depositAmount(String accId, double amt) {
		// TODO Auto-generated method stub
		
		Account acc = em.find(Account.class, accId);
		
		if(acc!=null) {
		System.out.println("before update : "+acc.getDepositAmount());
		
		double temp = acc.getDepositAmount()+amt;
		em.getTransaction().begin();
		acc.setDepositAmount(acc.getDepositAmount()+amt);
		em.getTransaction().commit();
		
		Transaction tran = new Transaction( acc, amt, TransactionType.Account_CREDIT);
		em.getTransaction().begin();
		em.persist(tran);
		em.getTransaction().commit();
		
//		tran.setTransactionId((int)Math.random()*50+50);
//		tran.setTransactionAmt(amt);
//		tran.setTransactionType(TransactionType.Account_CREDIT);
		
		return temp;
		}
		else {
			System.out.println("Invalid account no.!!!");
			return 0;
		}
	}

	@Override
	public double withdrawAmount(String accId, double amt) {
		// TODO Auto-generated method stub
		//Transaction tran = new Transaction();
		
		Account acc = em.find(Account.class, accId);
		
		if(acc!=null) {
		System.out.println("before update : "+acc.getDepositAmount());
		
		em.getTransaction().begin();
		double a = acc.getDepositAmount()-amt;
		acc.setDepositAmount(acc.getDepositAmount()-amt);
		em.getTransaction().commit();
		
		Transaction transaction = new Transaction(acc, amt, TransactionType.Account_DEBIT);
		
		//tran.setAccountId(acc.getAcc_Id());
//		tran.setTransactionId((int)Math.random()*40+50);
//		tran.setTransactionAmt(amt);
//		tran.setTransactionType(TransactionType.Account_DEBIT);
		em.getTransaction().begin();
		em.persist(transaction);
		em.getTransaction().commit();
		
		return a;
		}
		else {
			System.out.println("Invalid account no.!!!");
			return 0;
		}
	}

	@Override
	public double payLoan(String accId,double amt) {
		// TODO Auto-generated method stub
		
		double updatedAmt = 0;
		Loan loan = em.find(Loan.class, accId);
		
		if(loan!=null) {
		
		em.getTransaction().begin();
		updatedAmt = loan.getLoanAmt()-amt;
		loan.setLoanAmt(loan.getLoanAmt()-amt);
		em.getTransaction().commit();
		
		
		Transaction tran = new Transaction( loan, amt, TransactionType.LOAN_DEBIT);
		//t.setAccountId(loan.getAcc_Id());
		/*t.setTransactionId((int)Math.random()*40+50);
		t.setTransactionAmt(amt);
		t.setTransactionType(TransactionType.LOAN_DEBIT);*/
		em.getTransaction().begin();
		em.persist(tran);
		em.getTransaction().commit();
		return updatedAmt;
		}
		else {
			System.out.println("This "+accId+" no. doesn't have any loan record ");
			return updatedAmt;
		}
		
	}

	@Override
	public double getLoan(String loanId, double amt) {
		// TODO Auto-generated method stub
		
		double updatedAmt = 0;
		Loan loan = em.find(Loan.class, loanId);
		
		if(loan!=null) {
			em.getTransaction().begin();
			updatedAmt = loan.getLoanAmt()+amt;
			loan.setLoanAmt(loan.getLoanAmt()+amt);
			em.getTransaction().commit();
			
			Transaction tran = new Transaction( loan, amt, TransactionType.LOAN_CREDIT);
			em.getTransaction().begin();
			em.persist(tran);
			em.getTransaction().commit();
			return updatedAmt;
		}else {
			System.out.println("This "+loanId+" no. doesn't have any loan record ");
			return updatedAmt;
		}
		
	}

	@Override
	public List<Transaction> getTransactionDetails(String accountId) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		
//		String sql = "SELECT t FROM transaction t WHERE t.accountId = ?1";
//		TypedQuery<Transaction> q = em.createQuery(sql, Transaction.class);
//		List<Transaction> transactions = q.setParameter(1, accountId).getResultList();
//		
		Query q = em.createQuery("select i from transaction i");
		
		//List<Transaction> transactions = q.getResultList();
		//Query q = em.createNamedQuery("trxn");
		@SuppressWarnings("unchecked")
		List<Transaction> tr= (List<Transaction>)q.getResultList();
		
		em.getTransaction().commit();
		return tr;
	}

}
