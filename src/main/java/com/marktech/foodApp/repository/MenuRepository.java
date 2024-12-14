package com.marktech.foodApp.repository;

import com.marktech.foodApp.model.FoodItem;
import org.springframework.data.repository.CrudRepository;

public interface MenuRepository extends CrudRepository<FoodItem, Long> {
}
