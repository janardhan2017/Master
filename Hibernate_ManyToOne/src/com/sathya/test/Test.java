package com.sathya.test;

import com.sathya.dao.MTODao;
import com.sathya.dao.MToDaoImpl;

public class Test {

	public static void main(String[] args) {
		MTODao  dao =new  MToDaoImpl();
		dao.saveLoanWithCustomer();
		//dao.removeLoan("LN-091");
		

	}

}
