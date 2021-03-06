package com.springboot.application;
 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.springboot.model.Address;
import com.springboot.model.Authority;
import com.springboot.model.Employee;
import com.springboot.model.User;
import com.springboot.repositories.AuthorityRepository;
import com.springboot.repositories.UserRepository;
import com.springboot.services.AddressService;
import com.springboot.services.EmployeeService;

 
@SpringBootApplication(scanBasePackages = {"com.springboot"})
@EnableJpaRepositories(basePackages = {"com.springboot.repositories"})
@EntityScan(basePackages = {"com.springboot.model"})
public class MySpringBootApplication implements CommandLineRunner{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MySpringBootApplication.class);
	
    @Autowired
    EmployeeService employeeService;
    
    @Autowired
    AddressService addressService;
    
    @Autowired
    UserRepository userRepository;
    
    @Autowired
    AuthorityRepository authorityRepository;
    
    public static void main(String[] args) {
        SpringApplication.run(MySpringBootApplication.class, args);
    }
    
    @Override
    public void run(String... arg0) throws Exception {
    		List<Address> addresses = new ArrayList<>();
        Address address1 = new Address(1, "Allianz, Trivandrum", "695581");
        Address address2 = new Address(2, "Shyju Manzil, Anchal", "691306");
        addresses.add(address1);
        addresses.add(address2);
        Employee employee = new Employee("Shihad", "i84126", addresses);
        
        Employee empl = employeeService.addEmployee(employee);
        LOGGER.info("Employee Added :: " + empl.getName());
        
        Authority auth1 = new Authority("PERMISSION_A");
        Authority auth2 = new Authority("PERMISSION_B");
        List<Authority> authorities = Arrays.asList(auth1, auth2);
        authorityRepository.saveAll(authorities);
        User user = new User("test", "test", true, authorities);
        userRepository.save(user);
        
        List<Address> addrss = addressService.findByPinCode("695581");
        for (Address address : addrss) {
        		LOGGER.info(address.getPinCode());
        }
    }
}
