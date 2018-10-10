package com.capgemini.shoppingapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.capgemini.shoppingapp.entity.Order;

public interface OrderRepository extends MongoRepository<Order, Integer>{

}
