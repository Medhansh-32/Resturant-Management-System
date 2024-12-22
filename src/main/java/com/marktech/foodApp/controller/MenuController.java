package com.marktech.foodApp.controller;

import com.marktech.foodApp.model.FoodItem;
import com.marktech.foodApp.service.ImageUploadService;
import com.marktech.foodApp.service.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class MenuController {

    private static final Logger log = LoggerFactory.getLogger(MenuController.class);
    private MenuService menuService;
    private ImageUploadService imageUploadService;

    public MenuController(MenuService menuService, ImageUploadService imageUploadService) {
        this.menuService = menuService;
        this.imageUploadService=imageUploadService;
    }

    @GetMapping("/menuList")
    public ResponseEntity<List<FoodItem>> getMenu() throws Exception {
        return new ResponseEntity<>(menuService.getAllFoodItems(), HttpStatus.OK);
    }

    @PostMapping("/image/upload")
    public String uploadImage(@RequestParam("image") MultipartFile file) {
        return imageUploadService.uploadImage(file);
    }
    @PostMapping("/addItem")
    public ResponseEntity addItem(@RequestBody List<FoodItem> foodItems) throws Exception {

        System.out.println(foodItems.get(0).getDescription());
        menuService.saveFoodItems(foodItems);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
