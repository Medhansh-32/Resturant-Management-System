package com.marktech.foodApp.controller;

import com.marktech.foodApp.model.Admin;
import com.marktech.foodApp.repository.AdminRepository;
import com.marktech.foodApp.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/admin")
public class AdminController {

    private static final Logger log = LoggerFactory.getLogger(AdminController.class);
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/register")
    public ResponseEntity addAdmin(@RequestBody Admin admin) {
        log.info(admin.toString());
        System.out.println(admin);
        log.info("req recived");
        if (admin.getAdminName() == null || admin.getAdminEmail() == null ||
                admin.getAdminPassword() == null || admin.getPhoneNumber() == null) {
            return new ResponseEntity<>("All fields are required", HttpStatus.BAD_REQUEST);
        }

        // You might want to add email format validation
        if (!admin.getAdminEmail().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            return new ResponseEntity<>("Invalid email format", HttpStatus.BAD_REQUEST);
        }

        // You might want to add password strength validation
        if (admin.getAdminPassword().length() < 6) {
            return new ResponseEntity<>("Password must be at least 6 characters", HttpStatus.BAD_REQUEST);
        }

        if (adminService.saveAdmin(admin)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Registration failed", HttpStatus.BAD_REQUEST);
        }
   }
}
