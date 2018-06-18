package com.springboot.services;

import com.springboot.model.Employee;

public interface EmployeeService {
	
	public Employee findByAddressId(long addressId);
	
	public Employee addEmployee(Employee employee);

	public Employee findEmployeeByName(String name);

	public void deleteEmployee(String name);
	
}
