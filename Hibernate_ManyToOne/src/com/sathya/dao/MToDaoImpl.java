package com.sathya.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.sathya.entity.Customer;
import com.sathya.entity.Loan;
import com.sathya.util.HibernateUtil;

public class MToDaoImpl implements MTODao {
	private  SessionFactory  factory;
	
	public MToDaoImpl() {
		factory = HibernateUtil.getSessionFactory();
	}

	@Override
	public void saveLoanWithCustomer() {
		
		Customer  customer=new  Customer();
		customer.setCustId("CU_01");
		customer.setCustName("Jana");
		
		Loan  loan1 =new  Loan();
		loan1.setLoanId("LN_25");
		loan1.setAmount(900000);
		loan1.setCustomer(customer);
		
		/*Loan  loan2 =new  Loan();
		loan2.setLoanId("LN_26");
		loan2.setAmount(1500000);
		loan2.setCustomer(customer);
		*/
		Session  session=factory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(loan1);
		//session.save(loan2);
		tx.commit();
		session.close();
		

	}
	
	@Override
	public void removeLoan(String loanId) {
		Session  session=factory.openSession();
		Loan  loan=(Loan)session.get(Loan.class, loanId);
		Transaction  tx = session.beginTransaction();
		session.delete(loan);
		tx.commit();
		session.close();
		
	}
	
	
}
