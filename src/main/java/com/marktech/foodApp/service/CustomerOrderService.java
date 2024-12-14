package com.marktech.foodApp.service;

import com.marktech.foodApp.model.Customer;
import com.marktech.foodApp.model.CustomerOrder;
import com.marktech.foodApp.model.FoodItem;
import com.marktech.foodApp.model.OrderStatus;
import com.marktech.foodApp.repository.CustomerOrderRepository;
import com.marktech.foodApp.repository.CustomerRepository;
import com.marktech.foodApp.repository.FoodItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerOrderService {

    private static final Logger log = LoggerFactory.getLogger(CustomerOrderService.class);
    private final FoodItemRepository foodItemRepository;
    private final CustomerOrderRepository customerOrderRepository;
    private final CustomerRepository customerRepository;

    public CustomerOrderService(FoodItemRepository foodItemRepository, CustomerOrderRepository customerOrderRepository, CustomerRepository customerRepository) {
        this.foodItemRepository = foodItemRepository;
        this.customerOrderRepository = customerOrderRepository;
        this.customerRepository = customerRepository;
    }

    public CustomerOrder addNewCustomerOrder(CustomerOrder customerOrder) {
        try {
            Customer customer = customerOrder.getCustomer();

            // Check if the customer exists
            Customer existingCustomer = customerRepository.findByName(customer.getName());
            if (existingCustomer != null) {
                customer = existingCustomer; // Reuse existing customer
            } else {
                customer = customerRepository.save(customer); // Save new customer
            }

            // Associate the customer with the order
            customerOrder.setCustomer(customer);

            // Update the bidirectional relationship
            if (customer.getOrders() == null) {
                customer.setOrders(new ArrayList<>());
            }


            // Calculate total price and associate food items
            Integer totalPrice = 0;
            List<FoodItem> foodItemList = new ArrayList<>();
            for (FoodItem item : customerOrder.getFoodItems()) {
                FoodItem foodItem = foodItemRepository.findByName(item.getName());
                if (foodItem == null) {
                    throw new RuntimeException("Food item not found: " + item.getName());
                }
                foodItemList.add(foodItem);
                totalPrice += foodItem.getPrice();
            }

            customerOrder.setFoodItems(foodItemList);
            customerOrder.setStatus(OrderStatus.IN_PROGRESS);
            customerOrder.setOrderDateTime(LocalDateTime.now());
            customerOrder.setTotalPrice(totalPrice);

            customer.setOrders(foodItemList);
            customerRepository.save(customer);
            // Save the order
            return customerOrderRepository.save(customerOrder);
        } catch (Exception e) {
            log.error("Error while saving customer order: ", e);
        }
        return null;
    }
    public List<CustomerOrder> getCustomerOrderByName(String name) {
   return    customerOrderRepository.findByCustomerId(customerRepository.findByName(name).getId());
    }
}
