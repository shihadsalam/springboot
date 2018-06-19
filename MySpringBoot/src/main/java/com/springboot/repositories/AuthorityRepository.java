package com.springboot.repositories;
 
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.model.Authority;
 
@Repository
public interface AuthorityRepository extends CrudRepository<Authority, Long> {
 
}