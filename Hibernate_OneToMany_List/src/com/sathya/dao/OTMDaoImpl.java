package com.sathya.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.sathya.entity.Customer;
import com.sathya.entity.Loan;
import com.sathya.util.HibernateUtil;

public class OTMDaoImpl implements OTMDao {
	private  SessionFactory  factory;
	public OTMDaoImpl() {
		factory = HibernateUtil.getSessionFactory();
	}

	@Override
	public void saveCustomerWithLoans() {
		Customer  customer=new  Customer();
		customer.setCustId("CI-001");
		customer.setCustName("A");
		
		Loan  loan1 =new  Loan();
		loan1.setLoanId("LN-091");
		loan1.setAmount(900000);
		
		Loan  loan2 =new  Loan();
		loan2.setLoanId("LN-092");
		loan2.setAmount(1500000);
		
		Loan  loan3 =new  Loan();
		loan3.setLoanId("LN-093");
		loan3.setAmount(500000);
		
		//create a collection 
		//add child objects to collection
		List<Loan>  loans = new  ArrayList<Loan>();
		loans.add(loan1);
		loans.add(loan2);
		loans.add(loan3);
		
		//set the collection to parent
		customer.setLoans(loans);
		
		//open a session, begin transaction,save customer
		Session session=factory.openSession();
		Transaction t = session.beginTransaction();
		session.save(customer);
		t.commit();
		session.close();
	}
	
	@Override
	public void removeLoanFromCustomer() {
		Session  session = factory.openSession();
		//load Customer from Database
		Customer  c =(Customer)session.get(Customer.class, "CI-001");
		//get collection of parent
		List<Loan>  loans = c.getLoans();
		//load  loan from Database
		Loan  l = (Loan)session.get(Loan.class, "LN-092");
		
		//begin Transaction
		Transaction t = session.beginTransaction();
		loans.remove(l);
		t.commit();
		session.close();
	}
	
}
