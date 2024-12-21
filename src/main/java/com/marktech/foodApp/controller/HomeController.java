package com.marktech.foodApp.controller;


import com.marktech.foodApp.model.Customer;
import com.marktech.foodApp.model.CustomerOrder;
import com.marktech.foodApp.model.FoodItem;
import com.marktech.foodApp.service.MenuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final MenuService menuService;

    public HomeController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("/menu")
    public String menu(Model model) {

        List<FoodItem>menuList=menuService.getAllFoodItems();
        model.addAttribute("menu",menuList);
        return "menu";

    }
    @GetMapping("/admin")
        public String admin(Model model) {
            return "admin";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }
    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
