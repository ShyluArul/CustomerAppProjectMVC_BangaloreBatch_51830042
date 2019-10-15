package com.custapp.model.persistance;

import java.util.List;

public interface CustomerDao {
	public List<Customer> getAllCustomers();

	public Customer getCustomerById(int cusId);

	public Customer addCustomer(Customer customer);

	public Customer updateCustomer(Customer customer);

	public Customer removeCustomer(int cusId);

}
