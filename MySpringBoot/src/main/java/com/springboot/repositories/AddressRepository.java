package com.springboot.repositories;
 
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.model.Address;
 
@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {
 
    List<Address> findByPinCode(String pinCode);
}