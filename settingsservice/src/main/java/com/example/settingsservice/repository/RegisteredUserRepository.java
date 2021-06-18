package com.example.settingsservice.repository;


import com.example.settingsservice.model.RegisteredUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisteredUserRepository extends JpaRepository<RegisteredUser, Integer> {

    RegisteredUser findOneById(Integer id);
    RegisteredUser findByUsername(String username);
}
