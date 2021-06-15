package com.example.followerservice.controller;

import com.example.followerservice.model.User;
import com.example.followerservice.repository.FollowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/follower")
public class FollowerController {

    @Autowired
    private FollowerRepository followerRepository;

    @GetMapping(value="/user")
    public ResponseEntity<User> getUser(){
        Integer idd=1;
        User user= this.followerRepository.findOneById(idd);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
