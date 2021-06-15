package com.example.settingsservice.controller;

import com.example.settingsservice.model.RegisteredUser;
import com.example.settingsservice.repository.RegisteredUserRepository;
import com.example.settingsservice.service.RegisteredUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registeredUsers")
public class RegisteredUserController {

    @Autowired
    private RegisteredUserService registeredUserService;

    /*private RegisteredUserRepository registeredUserRepository;

    @Autowired
    public void setUserRepository(RegisteredUserRepository registeredUserRepository) {
        this.registeredUserRepository = registeredUserRepository;
    }

    @GetMapping("/allUsers")
    public ResponseEntity<String> sviUseri(){
        return new ResponseEntity<>(registeredUserRepository.findOneById(2).getName(), HttpStatus.OK);
    }

    @GetMapping("/greska")
    public ResponseEntity<RegisteredUser> greska(){
        return new ResponseEntity<>(registeredUserRepository.findOneById(1), HttpStatus.OK);
    }
       */


}
