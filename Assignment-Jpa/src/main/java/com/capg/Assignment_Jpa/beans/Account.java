package com.capg.Assignment_Jpa.beans;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "account_details")
@Inheritance(strategy = InheritanceType.JOINED)
public class Account {
	
	@Id
	private String acc_Id;
	@Column(nullable = false,length = 30)
	private String accHolderName;
	@Column(nullable = false)
	private double depositAmount;
	@Embedded
	private Address address;
	
	@OneToMany(mappedBy = "accountId")
	private List<Transaction> transaction;
	
	
	public String getAcc_Id() {
		return acc_Id;
	}
	public void setAcc_Id(String acc_Id) {
		this.acc_Id = acc_Id;
	}
	public String getAccHolderName() {
		return accHolderName;
	}
	public void setAccHolderName(String accHolderName) {
		this.accHolderName = accHolderName;
	}
	public double getDepositAmount() {
		return depositAmount;
	}
	public void setDepositAmount(double depositAmount) {
		this.depositAmount = depositAmount;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Account(String acc_Id, String accHolderName, double depositAmount, Address address) {
		super();
		this.acc_Id = acc_Id;
		this.accHolderName = accHolderName;
		this.depositAmount = depositAmount;
		this.address = address;
	}
	public Account() {
		super();
	}
	
	

}
