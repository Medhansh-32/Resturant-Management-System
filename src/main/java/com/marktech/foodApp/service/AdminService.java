package com.marktech.foodApp.service;

import com.marktech.foodApp.model.Admin;
import com.marktech.foodApp.repository.AdminRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    private static final Logger log = LoggerFactory.getLogger(AdminService.class);
    private final AdminRepository adminRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public Boolean saveAdmin(Admin admin) {
        try {
            admin.setAdminPassword(bCryptPasswordEncoder.encode(admin.getAdminPassword()));
            adminRepository.save(admin);
            return true;
        }catch (Exception e){
            log.error(e.getMessage());
            return false;
        }

    }

}
