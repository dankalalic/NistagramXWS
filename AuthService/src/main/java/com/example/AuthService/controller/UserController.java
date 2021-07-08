package com.example.AuthService.controller;


import com.example.AuthService.model.*;
import com.example.AuthService.repository.UserRepository;
import com.example.AuthService.service.AuthorityService;
import com.example.AuthService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value="/users", produces=MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private UserService userService;

    private UserRepository userRepository;

    @Autowired
    private AuthorityService authService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public void setUserRepository(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    /*@GetMapping(value="/user",produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('PATIENT')")
    public ResponseEntity<User> getKorisnik() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }*/

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value="/ugasiProfil")
    public ResponseEntity<StringDTO>  ugasiProfil(@RequestBody StringDTO stringDTO) {
        return new ResponseEntity<>(userService.ugasiProfil(stringDTO.getString()), HttpStatus.OK);
    }


    @PostMapping(value="/targetAge",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> doFollow(@RequestBody TargetGroupDTO targetGroupDTO) {
        User user = userRepository.getOne(targetGroupDTO.getId());

        Boolean bool=false;

        if ((user.getAge()>=targetGroupDTO.getPocetak())&&(user.getAge()<=targetGroupDTO.getKraj())){
            bool=true;
        }


        return new ResponseEntity<>(bool,HttpStatus.OK);

    }
    @PostMapping(value="/adduser",consumes = MediaType.APPLICATION_JSON_VALUE)
    public Boolean addUser(@RequestBody UserDTO idDoubleDTO) {
        User user = new User();
        user.setId(idDoubleDTO.getId());
        user.setUsername(idDoubleDTO.getUsername());
        user.setPassword(passwordEncoder.encode(idDoubleDTO.getLozinka()));
        user.setEnabled(true);
        List<Authority> auth = authService.findByname("ROLE_USER");
        user.setAuthorities(auth);
        userRepository.save(user);

        return true;

    }
}
