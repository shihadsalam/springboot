package com.springboot.application;
 
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springboot.model.Address;
import com.springboot.model.Employee;
import com.springboot.services.EmployeeService;
 
@SpringBootApplication
public class MySpringBootApplication implements CommandLineRunner{
    
    @Autowired
    EmployeeService employeeService;
    
    public static void main(String[] args) {
        SpringApplication.run(SpringBootApplication.class, args);
    }
    
    @Override
    public void run(String... arg0) throws Exception {
    		List<Address> addresses = new ArrayList<>();
        Address address1 = new Address(1, "Street1", "123456");
        Address address2 = new Address(2, "Street2", "654321");
        Address address3 = new Address(3, "Street3", "321654");
        addresses.add(address1);
        addresses.add(address2);
        addresses.add(address3);
        Employee employee = new Employee("Emp1", "Code1", addresses);
        
        employeeService.addEmployee(employee);
    }
}