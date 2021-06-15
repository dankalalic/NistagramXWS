package com.example.settingsservice.service;

import com.example.settingsservice.model.User;
import com.example.settingsservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


}
