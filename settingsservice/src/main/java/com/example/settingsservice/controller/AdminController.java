package com.example.settingsservice.controller;

import com.example.settingsservice.model.RegisteredUser;
import com.example.settingsservice.model.ZahteviZaPracenje;
import com.example.settingsservice.model.idDTO;
import com.example.settingsservice.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/admins")
public class AdminController {

    @Autowired
    private AdminService adminService;

}
