package com.app.service;

import com.app.model.Customer;

public interface ICustomerService {

	public int saveCustomer(Customer cust);

	public Customer getCustByMailId(String mailId);

}
