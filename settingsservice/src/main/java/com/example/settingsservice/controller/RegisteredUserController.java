package com.example.settingsservice.controller;

import com.example.settingsservice.dto.UserChangeDTO;
import com.example.settingsservice.model.RegisteredUser;
import com.example.settingsservice.model.UserRequest;
import com.example.settingsservice.service.RegisteredUserService;
import com.example.settingsservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/registeredUsers")
public class RegisteredUserController {

    @Autowired
    private RegisteredUserService registeredUserService;

    @Autowired
    private UserService userService;

    @PostMapping(value="/changeRegisteredUserInfo", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    //@PreAuthorize("hasRole('REGISTEREDUSER')")
    public ResponseEntity<RegisteredUser> changeRegisteredUserInfo(@RequestBody UserChangeDTO userDTO) {

        RegisteredUser user = registeredUserService.changeRegisteredUserInfo(userDTO);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

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


    @PostMapping(value="/signup", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RegisteredUser> addUser(@RequestBody UserRequest userRequest, UriComponentsBuilder ucBuilder) throws ResourceConflictException {

        RegisteredUser existUser = this.registeredUserService.findByUsername(userRequest.getUsername());
        if (existUser != null) {
            throw new ResourceConflictException(userRequest.getId(), "Username already exists");
        }

        RegisteredUser registeredUser = this.registeredUserService.save(userRequest);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/user/{userId}").buildAndExpand(registeredUser.getId()).toUri());
        return new ResponseEntity<RegisteredUser>(registeredUser, HttpStatus.CREATED);
    }

}
