package com.sathya.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CUSTOMER_TAB")
public class Customer {
	@Id
	@Column(name="CUST_ID",length=8)
	
	private  String  custId;
	
	@Column(name="CUST_NAME",length=12)
	private  String  custName;

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}


}
