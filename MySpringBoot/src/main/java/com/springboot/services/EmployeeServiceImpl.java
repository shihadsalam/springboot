package com.springboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.model.Employee;
import com.springboot.repositories.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	@Transactional
	public Employee findByAddressId(long addressId) {
		return employeeRepository.findByAddressId(addressId);
	}

	@Override
	@Transactional
	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	@Transactional
	public Employee findEmployeeByName(String name) {
		return employeeRepository.findByName(name);
	}

	@Override
	@Transactional
	public void deleteEmployee(String name) {
		employeeRepository.delete(findEmployeeByName(name));;
	}

	@Override
	@Transactional
	public boolean update(Employee employee) {
		Employee existingEmployee = findEmployeeByName(employee.getName());
		if (null != existingEmployee) {
			existingEmployee.update(employee);
			return true;
		}
		else {
			employeeRepository.save(employee);
			return false;
		}
	}

}
