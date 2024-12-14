package com.marktech.foodApp.repository;

import com.marktech.foodApp.model.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends CrudRepository<Admin, Long> {
    Admin findByAdminName(String username);

    Admin findByAdminEmail(String email);
}
