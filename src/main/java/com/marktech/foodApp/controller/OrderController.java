package com.marktech.foodApp.controller;

import com.marktech.foodApp.model.CustomerOrder;
import com.marktech.foodApp.repository.CustomerOrderRepository;
import com.marktech.foodApp.service.CustomerOrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final CustomerOrderRepository customerOrderRepository;
    private final CustomerOrderService customerOrderService;

    public OrderController(CustomerOrderRepository customerOrderRepository, CustomerOrderService customerOrderService) {
        this.customerOrderRepository = customerOrderRepository;
        this.customerOrderService = customerOrderService;
    }

    @PostMapping("/newOrder")
    public CustomerOrder newOrder(@RequestBody CustomerOrder order) {
     return  customerOrderService.addNewCustomerOrder(order);
    }

    @GetMapping("/orderByName")
    public List<CustomerOrder> getOrdersByName(@RequestParam("name") String name) {
return customerOrderService.getCustomerOrderByName(name);
    }
}
