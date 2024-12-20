package com.marktech.foodApp.service;

import com.marktech.foodApp.WebSockets.OrderWebSocketHandler;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    private final OrderWebSocketHandler orderWebSocketHandler;

    public CustomerOrderService(FoodItemRepository foodItemRepository, CustomerOrderRepository customerOrderRepository, CustomerRepository customerRepository, OrderWebSocketHandler orderWebSocketHandler) {
        this.foodItemRepository = foodItemRepository;
        this.customerOrderRepository = customerOrderRepository;
        this.customerRepository = customerRepository;
        this.orderWebSocketHandler = orderWebSocketHandler;
    }

    public List<CustomerOrder> getCustomerOrders() {
        return (List<CustomerOrder>) customerOrderRepository.findAll();
    }

    public ResponseEntity<CustomerOrder> addNewCustomerOrder(CustomerOrder customerOrder) {
        try {
            Customer customer = customerOrder.getCustomer();

            // Check if the customer exists
            Customer existingCustomer = customerRepository.findByName(customer.getName());
            if (existingCustomer != null) {
                customer = existingCustomer; // Reuse existing customer
            } else {
                customer = customerRepository.save(customer); // Save new customer
            }
            customerOrder.setCustomer(customer);
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

            customerOrder= customerOrderRepository.save(customerOrder);
            orderWebSocketHandler.sendOrderUpdate(customerOrder);
            return new ResponseEntity<>(customerOrder, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error while saving customer order: ", e);
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
    public List<CustomerOrder> getCustomerOrderByName(String name) {
   return    customerOrderRepository.findByCustomerId(customerRepository.findByName(name).getId());
    }
}
