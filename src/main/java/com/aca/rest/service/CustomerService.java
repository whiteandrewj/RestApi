package com.aca.rest.service;

import java.util.List;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import com.aca.rest.dao.CustomerDao;
import com.aca.rest.dao.MovieDao;
import com.aca.rest.model.Customer;
import com.aca.rest.model.Movie;

public class CustomerService {
	
	public List<Customer> getAllCustomers() {
		
		CustomerDao dao = new CustomerDao();
		return dao.getAllCustomers();
	}
	
	public int updateCustomer(Customer customer) {
		CustomerDao customerDao = new CustomerDao();
		return customerDao.updateCustomer(customer);
	}

	public int insertCustomer(Customer customer) {
		CustomerDao customerDao = new CustomerDao();
		return customerDao.insertCustomer(customer);
	}
}
