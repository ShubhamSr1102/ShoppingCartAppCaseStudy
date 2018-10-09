package com.capgemini.customer.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.capgemini.customer.entities.Customer;

public interface CustomerRepository extends MongoRepository<Customer, Integer> {

	@Query("{'customerName': {$regex:?0}}")
	public List<Customer> findByCustomerName(String name);
}
