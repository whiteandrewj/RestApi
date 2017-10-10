package com.aca.rest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.aca.rest.model.Customer;

public class CustomerDao {
	
	private final static String sql = " SELECT CustomerID, CompanyName, City, Country " +
										" FROM customer ";
	
	private final static String SQL_UPDATE_CUSTOMER_BY_ID = " UPDATE customer " +
										" SET companyName = ? , city = ? , country = ? " +
										" WHERE CustomerID = ? ";
	
	private final static String SQL_INSERT_CUSTOMER = " INSERT INTO customer " +
														" (customerID, companyName, city, country) " +
														" VALUES (?, ?, ?, ?) ";

	public List<Customer> getAllCustomers() {
	
		List<Customer> customers = new ArrayList<Customer>();
	
		ResultSet result = null;
		Statement statement = null;
		
		Connection conn = MariaDbUtil.getConnection();
		
		try {
			// General purpose access to your database
			// useful when you are using static SQL statements at runtime
			// The Statement interface cannot accept parameters
			
			statement = conn.createStatement();
			
			//.executeQuery returns a ResultSet object
			//use this method when you expect to get a result set
			//as you would with a SELECT statement
			result = statement.executeQuery(sql);
			
			while(result.next()) {
				Customer customer = new Customer();
				customer.setCustomerId(result.getString("CustomerID"));
				customer.setCompanyName(result.getString("CompanyName"));
				customer.setCity(result.getString("City"));
				customer.setCountry(result.getString("Country"));
				customers.add(customer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				result.close();
				statement.close();
				conn.close();
			} catch (SQLException e){
				e.printStackTrace();
			}
		}
		return customers;
	}
	
	public int updateCustomer(Customer customer) {
	
		int rowsUpdated = 0;
		PreparedStatement statement = null;
		
		Connection conn = MariaDbUtil.getConnection();
		
		try {
			// General purpose access to your database
			// useful when you are using static SQL statements at runtime
			// The Statement interface cannot accept parameters
			
			statement = conn.prepareStatement(SQL_UPDATE_CUSTOMER_BY_ID);
			statement.setString(1, customer.getCompanyName());
			statement.setString(2, customer.getCity());
			statement.setString(3, customer.getCountry());
			statement.setString(4, customer.getCustomerId());
			
			//returns a ResultSet object
			//use this method when you expect to get a result set
			//as you would with a SELECT statement
			rowsUpdated = statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				conn.close();
			} catch (SQLException e){
				e.printStackTrace();
			}
		}
		return rowsUpdated;
	}
	
	public int insertCustomer(Customer customer) {
		
		int rowsInserted = 0;
		PreparedStatement statement = null;
		
		Connection conn = MariaDbUtil.getConnection();
		
		try {
			// General purpose access to your database
			// useful when you are using static SQL statements at runtime
			// The Statement interface cannot accept parameters
			
			statement = conn.prepareStatement(SQL_INSERT_CUSTOMER);
			statement.setString(1, customer.getCustomerId());
			statement.setString(2, customer.getCompanyName());
			statement.setString(3, customer.getCity());
			statement.setString(4, customer.getCountry());
			
			
			//.executeQuery returns a ResultSet object
		
			rowsInserted = statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				conn.close();
			} catch (SQLException e){
				e.printStackTrace();
			}
		}
		return rowsInserted;
	}
}


