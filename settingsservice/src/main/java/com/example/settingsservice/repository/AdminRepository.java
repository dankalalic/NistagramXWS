package com.example.settingsservice.repository;

import com.example.settingsservice.model.Admin;
import com.example.settingsservice.model.RegisteredUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

    Admin findOneById(Integer id);
}
