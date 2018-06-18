package com.springboot.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> { 
	
	public Employee findByAddressId(long addressId);

	public Employee findByName(String name);

}
