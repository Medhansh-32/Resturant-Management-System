package com.marktech.foodApp.controller;

import com.marktech.foodApp.model.CustomerOrder;
import com.marktech.foodApp.repository.CustomerOrderRepository;
import com.marktech.foodApp.service.CustomerOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private static final Logger log = LoggerFactory.getLogger(OrderController.class);
    private final CustomerOrderRepository customerOrderRepository;
    private final CustomerOrderService customerOrderService;

    public OrderController(CustomerOrderRepository customerOrderRepository, CustomerOrderService customerOrderService) {
        this.customerOrderRepository = customerOrderRepository;
        this.customerOrderService = customerOrderService;
    }

    @PostMapping("/newOrder")
    public ResponseEntity newOrder(@RequestBody CustomerOrder order) {
        log.info("new Order");
    return customerOrderService.addNewCustomerOrder(order);
    }

    @GetMapping("/allOrders")
    public ResponseEntity getAllOrders() {
        log.info("getAllOrders");
        return new ResponseEntity(customerOrderService.getCustomerOrders(), HttpStatus.OK);
    }
    @GetMapping("/orderByName")
    public List<CustomerOrder> getOrdersByName(@RequestParam("name") String name) {
        return customerOrderService.getCustomerOrderByName(name);
    }
    @DeleteMapping("/deleteOrder")
    public ResponseEntity deleteOrder(@RequestParam("orderId") Long orderId) {
        log.info("deleteOrder");
      if(customerOrderService.deleteOrderById(orderId)){
          return new ResponseEntity(HttpStatus.OK);
      }else{
          return new ResponseEntity(HttpStatus.NOT_FOUND);
      }
    }
}
