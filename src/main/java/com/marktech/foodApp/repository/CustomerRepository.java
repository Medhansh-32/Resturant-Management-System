package com.marktech.foodApp.repository;

import com.marktech.foodApp.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    Customer findByName(String name);
}
