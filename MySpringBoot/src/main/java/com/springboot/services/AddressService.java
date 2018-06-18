package com.springboot.services;

import java.util.List;

import com.springboot.model.Address;

public interface AddressService {
	
	public List<Address> findByPinCode(String pinCode);
	
}
