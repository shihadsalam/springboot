package com.springboot.services;

import com.springboot.model.Employee;

public interface EmployeeService {
	
	public Employee findByAddressId(long addressId);
	
	public void addEmployee(Employee employee);
	
}
