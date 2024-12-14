package com.marktech.foodApp.service;



import com.marktech.foodApp.model.Admin;
import com.marktech.foodApp.repository.AdminRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AdminDetailServiceImpl implements UserDetailsService {

    private AdminRepository adminRepository;
    public AdminDetailServiceImpl(AdminRepository adminRepository ) {
        this.adminRepository = adminRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin user1=adminRepository.findByAdminEmail(username);
        if(user1!=null) {
            return org.springframework.security.core.userdetails.User.builder()
                    .username(user1.getAdminName())
                    .password(user1.getAdminPassword())
                    .build();
        }
        Admin user=adminRepository.findByAdminName(username);
        if(user!=null){
            return org.springframework.security.core.userdetails.User.builder()
                    .username(user.getAdminName())
                    .password(user.getAdminPassword())
                    .build();
        }
        throw new UsernameNotFoundException("Admin not found");

    }
}