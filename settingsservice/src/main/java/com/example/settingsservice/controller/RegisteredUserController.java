package com.example.settingsservice.controller;

import com.example.settingsservice.TokenUtils;
import com.example.settingsservice.dto.UserChangeDTO;
import com.example.settingsservice.model.*;
import com.example.settingsservice.service.RegisteredUserService;
import com.example.settingsservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/registeredUsers")
public class RegisteredUserController {

    @Autowired
    private RegisteredUserService registeredUserService;

    @Autowired
    private UserService userService;

    @Autowired
    private TokenUtils tokenUtils;

    @PostMapping(value="/changeRegisteredUserInfo", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    //@PreAuthorize("hasRole('REGISTEREDUSER')")
    public ResponseEntity<RegisteredUser> changeRegisteredUserInfo(@RequestBody UserChangeDTO userDTO, @RequestHeader(value="Authorization") String token) {
        Integer id = tokenUtils.getIdFromToken(token);
        RegisteredUser user = registeredUserService.changeRegisteredUserInfo(userDTO, id);

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

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value="/privacySettings")
    public ResponseEntity<RegisteredUser> privacyAndNotifSettings(@RequestBody privacyDTO privacyDTO, @RequestHeader(value="Authorization") String token) {
        Integer id = tokenUtils.getIdFromToken(token);
        return new ResponseEntity<>(registeredUserService.privacyAndNotificationSettings(id, privacyDTO.getTaggable(), privacyDTO.getIsp(),
                privacyDTO.getAcceptMsg(), privacyDTO.getAllowNotifs()), HttpStatus.OK);
    }

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

    @PostMapping(value="/block", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RegisteredUser> block(@RequestBody IdOnlyDTO idDTO, @RequestHeader(value="Authorization") String token) {
        Integer id = tokenUtils.getIdFromToken(token);
        return new ResponseEntity<>(registeredUserService.block(idDTO.getId(), id), HttpStatus.OK);
    }


}
