package com.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.model.Address;
import com.springboot.repositories.AddressRepository;

@Service
public class AddressServiceImpl implements AddressService {
	
	@Autowired
	private AddressRepository addressRepository;

	public List<Address> findByEmployeeId(long employeeId) {
		return addressRepository.findByEmployeeId(employeeId);
	}

}
