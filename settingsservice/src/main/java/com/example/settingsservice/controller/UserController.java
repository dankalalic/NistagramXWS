package com.example.settingsservice.controller;

import com.example.settingsservice.TokenUtils;
import com.example.settingsservice.model.RegisteredUser;
import com.example.settingsservice.model.User;
import com.example.settingsservice.model.UserAndPrivacyDTO;
import com.example.settingsservice.model.privacyDTO;
import com.example.settingsservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenUtils tokenUtils;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value="/changeProfile")
    public ResponseEntity<UserAndPrivacyDTO> changeProfile(@RequestHeader(value="Authorization") String token) {
        Integer id = tokenUtils.getIdFromToken(token);
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }
}
