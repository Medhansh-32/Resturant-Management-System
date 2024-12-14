package com.marktech.foodApp.repository;

import com.marktech.foodApp.model.Customer;
import com.marktech.foodApp.model.CustomerOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerOrderRepository extends CrudRepository<CustomerOrder,Long> {
List<CustomerOrder> findByCustomerId(Long customerId);

}
