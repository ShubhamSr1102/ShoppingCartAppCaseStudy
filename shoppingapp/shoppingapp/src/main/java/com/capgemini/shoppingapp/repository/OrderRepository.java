package com.capgemini.shoppingapp.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.capgemini.shoppingapp.entity.Order;

public interface OrderRepository extends MongoRepository<Order, Integer>{

	@Query("{'deleted':false}")
	public List<Order> findByDeleted(String deleted);
}
