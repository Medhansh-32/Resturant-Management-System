package com.marktech.foodApp.service;

import com.marktech.foodApp.model.FoodItem;
import com.marktech.foodApp.repository.MenuRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuService {

    private final MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public List<FoodItem> getAllFoodItems() {
        return (List<FoodItem>) menuRepository.findAll();
    }

    public Boolean saveFoodItems(List<FoodItem> foodItem) {
        menuRepository.saveAll(foodItem);
        return true;
    }
}
