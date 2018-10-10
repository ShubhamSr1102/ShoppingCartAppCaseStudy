package com.capgemini.shoppingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.shoppingapp.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
