package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.ICustomerDao;
import com.app.model.Customer;

@Repository
public class CustomerDaoImpl implements ICustomerDao {

	@Autowired
	private HibernateTemplate ht;

	@Override
	public int saveCustomer(Customer cust) {
		return (Integer) ht.save(cust);
	}

	@Override
	public Customer getCustByMailId(String mailId) {

		Customer cust = null;
		String hql = "from " + Customer.class.getName() + " where custEmail=?";
		List<Customer> custList = ht.find(hql, mailId);
		if (custList != null && custList.isEmpty()) {
			cust = custList.get(0);
		}
		return cust;
	}
}
