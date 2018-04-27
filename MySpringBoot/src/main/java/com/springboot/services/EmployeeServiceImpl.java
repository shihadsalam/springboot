package com.springboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.model.Employee;
import com.springboot.repositories.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee findByAddressId(long addressId) {
		return employeeRepository.findByAddressId(addressId);
	}

	@Override
	public void addEmployee(Employee employee) {
		employeeRepository.save(employee);
	}

}
