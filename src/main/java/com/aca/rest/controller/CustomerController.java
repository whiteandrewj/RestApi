package com.aca.rest.controller;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.aca.rest.model.Customer;
import com.aca.rest.model.Movie;
import com.aca.rest.service.CustomerService;
import com.aca.rest.service.MovieService;


/**
 * The controller classes/methods are identified in the web.xml file.
 *The 'Path' annotation maps to the URL's path resources.
 *The 'GET' annotation identifies the HTTP method that is accepted.
 *The 'Produces' annotation identifies the MEdia Types (e.g. json, text, xml, etc) that this class/method can produce
 *
 *This class/method ill only accept a request with the following
 *1. HTTP Get
 *2. path '/RestApiApp/rest/movie'
 *3. HTTP header Accept = application/xml
 *
 */

@Path("/customer")		
public class CustomerController {
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON}) //{} within the parameters creates a 'collection'
	public List<Customer> getAllCustomers() {
		
		CustomerService service = new CustomerService();
		List<Customer> customers = service.getAllCustomers();
		
		return customers;
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public int updateCustomer(Customer customer) {
		
		CustomerService service = new CustomerService();
		int rowsDeleted = service.updateCustomer(customer);
		
		return rowsDeleted;
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public int insertCustomer(Customer customer) {
		
		CustomerService service = new CustomerService();
		int rowsDeleted = service.insertCustomer(customer);
		// TEST
		return rowsDeleted;
	}
	
}
