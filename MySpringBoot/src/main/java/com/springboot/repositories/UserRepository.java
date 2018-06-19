package com.springboot.repositories;
 
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.model.User;
 
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
 
    User findByUsername(String userName);
}