package com.sathya.test;

import com.sathya.dao.OTMDao;
import com.sathya.dao.OTMDaoImpl;

public class Test {

	public static void main(String[] args) {
		OTMDao  dao = new  OTMDaoImpl();
		//dao.saveCustomerWithLoans();
		dao.removeLoanFromCustomer();

	}
}
