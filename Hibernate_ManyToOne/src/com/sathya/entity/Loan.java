package com.sathya.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="LOAN_TAB")
public class Loan {
	@Id
	@Column(name="LOAN_ID",length=8)
	
	private  String  loanId;
	@Column(name="AMOUNT")
	private  double  amount;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="CUST_ID_FK")
	private  Customer  customer;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getLoanId() {
		return loanId;
	}

	public void setLoanId(String loanId) {
		this.loanId = loanId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
	

}
