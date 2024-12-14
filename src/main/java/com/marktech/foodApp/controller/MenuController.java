package com.marktech.foodApp.controller;

import com.marktech.foodApp.model.FoodItem;
import com.marktech.foodApp.service.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MenuController {

    private static final Logger log = LoggerFactory.getLogger(MenuController.class);
    private MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("/menu")
    public ResponseEntity<List<FoodItem>> getMenu() throws Exception {
        return new ResponseEntity<>(menuService.getAllFoodItems(), HttpStatus.OK);
    }

    @PostMapping("/addItem")
    public Boolean addItem(@RequestBody List<FoodItem> foodItems) throws Exception {

        System.out.println(foodItems.get(0).getDescription());
        menuService.saveFoodItems(foodItems);
        return true;
    }
}
