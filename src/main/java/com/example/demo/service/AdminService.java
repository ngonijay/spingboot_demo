package com.example.demo.service;

import com.example.demo.domain.Admin;
import com.example.demo.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {

    private final AdminRepository adminRepository;

    @Autowired
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public void registerAdmin(Admin admin) {
        Optional<Admin> isAdminPresent = adminRepository.findAdminByEmail(admin.getEmail());

        if (isAdminPresent.isPresent()){
            throw new IllegalStateException("Admin already registed");
        }

        Admin newAdmin = Admin.builder()
                .firstName(admin.getFirstName())
                .lastName(admin.getLastName())
                .email(admin.getEmail())
                .userType(admin.getUserType())
                .phoneNumber(admin.getPhoneNumber())
                .password(admin.getPassword())
                .build();

        adminRepository.save(newAdmin);
    }
}
