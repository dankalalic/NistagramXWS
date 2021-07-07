package com.example.followerservice.controller;

import com.example.followerservice.TokenUtils;
import com.example.followerservice.UserService;
import com.example.followerservice.model.DTO.IdDTO;
import com.example.followerservice.model.DTO.IdDoubleDTO;
import com.example.followerservice.model.DTO.UserDTO;
import com.example.followerservice.model.User;
import com.example.followerservice.repository.FollowerRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "/follower")
public class FollowerController {


    private UserService userService;

    @Autowired
    public void setUserService(UserService userService){this.userService=userService;}

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    TokenUtils tokenUtils;

    @Autowired
    private FollowerRepository followerRepository;

    @GetMapping(value="/user")
    public ResponseEntity<User> getUser(){
        Integer idd=1;
        User user= this.followerRepository.findOneById(idd);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping(value="/follow",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> followSomeone(@RequestBody IdDTO idDTO, @RequestHeader(value="Authorization") String token) {
        Integer id = tokenUtils.getIdFromToken(token);
        Integer id2=idDTO.getId();
        User user= this.followerRepository.findOneById(id);
        User user1= this.followerRepository.findOneById(id2);
        User user2= new User();
        User user3= new User();
        if (user1.getPrivate()==false){
            Set<User> following=user.getFollowing();
            Set<User> followers=user1.getFollowers();

            following.add(user1);
            user.setFollowing(following);

            user2=userService.save(user);

            followers.add(user);
            user1.setFollowers(followers);

            user3=userService.save(user1);

        }

       List<Integer> integers= new ArrayList<>();

        for (User user4: user2.getFollowers()){
            integers.add(user4.getId());
        }
        for (User user4: user2.getFollowing()){
            integers.add(user4.getId());
        }

        for (User user4: user3.getFollowers()){
            integers.add(user4.getId());
        }
        for (User user4: user3.getFollowing()){
            integers.add(user4.getId());
        }

       String url="https://settingsservice/zahteviZaPracenje/primazahtev";

        UserDTO userDTO = new UserDTO(id, id2);
       Boolean bolean= restTemplate.postForObject("http://settingsservice/zahteviZaPracenje/primazahtev",userDTO,Boolean.class);


       Set<User> users= new HashSet<>();

       users.add(user2);
       users.add(user3);

        return new ResponseEntity<>(bolean,HttpStatus.OK);
    }

    @PostMapping(value="/isPrivate",consumes = MediaType.APPLICATION_JSON_VALUE)
    public Boolean isPrivate(@RequestBody IdDTO idDTO) {
        User user = userService.findById(idDTO.getId());
        return user.getPrivate().equals(true);
    }


    @PostMapping(value="/doIFollow",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> doFollow(@RequestBody IdDoubleDTO idDoubleDTO) {
        User user = userService.findById(idDoubleDTO.getId1());
        Set<User> users = user.getFollowing();
        User user2 =userService.findById(idDoubleDTO.getId2());
        Boolean bool=false;

        if (users.contains(user2)){
            bool=true;
        }

        return new ResponseEntity<>(bool,HttpStatus.OK);

    }

}
