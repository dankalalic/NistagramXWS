package com.example.AuthService.service;

import com.example.AuthService.model.*;
import com.example.AuthService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.nio.file.AccessDeniedException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthorityService authService;

    @Autowired
    private RestTemplate restTemplate;

    public User findById(Integer id) throws AccessDeniedException {
        User u = userRepository.findById(id).orElseGet(null);
        return u;
    }

    public List<User> findAll() throws AccessDeniedException {
        List<User> result = userRepository.findAll();
        return result;
    }

    public User save(UserRequest userRequest) {
        User u = new User();
        u.setUsername(userRequest.getUsername());
        // pre nego sto postavimo lozinku u atribut hesiramo je
        u.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        u.setEnabled(true);

        List<Authority> auth = authService.findByname("ROLE_USER");
        // u primeru se registruju samo obicni korisnici i u skladu sa tim im se i dodeljuje samo rola USER
        u.setAuthorities(auth);

        u = this.userRepository.save(u);
        return u;
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public StringDTO ugasiProfil(String username){
        User user = findByUsername(username);
        user.setEnabled(false);
        this.userRepository.save(user);


        StringDTO stringDTO = new StringDTO(username);
        Boolean bolean= restTemplate.postForObject("http://postservice/posts/ugasiSvePostoveUsera",stringDTO,Boolean.class);

        if(bolean) {
            String s = "Uspesno ste ugasili profil";
            StringDTO returnString = new StringDTO(s);
            return returnString;
        }else {
            return null;
        }

    }
}
