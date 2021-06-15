package com.example.settingsservice.service;

import com.example.settingsservice.repository.RegisteredUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisteredUserService {
    
    @Autowired
    private RegisteredUserRepository registeredUserRepository;

    
}
