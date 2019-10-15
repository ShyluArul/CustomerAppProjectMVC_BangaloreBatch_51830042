package com.custapp.model.persistance;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	@Autowired
	private SessionFactory factory;

	private Session getSession() {
		return factory.getCurrentSession();
	}

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> getAllCustomers() {
		return getSession().createQuery("from Customer").list();
	}

	@Override
	public Customer getCustomerById(int cusId) {

		return (Customer) getSession().get(Customer.class, cusId);
	}

	@Override
	public Customer addCustomer(Customer customer) {
		getSession().save(customer);
		return customer;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		getSession().update(customer);
		return customer;

	}

	@Override
	public Customer removeCustomer(int cusId) {
		Customer customerToBeDeleted = getCustomerById(cusId);
		getSession().delete(customerToBeDeleted);
		return customerToBeDeleted;
	}

}
