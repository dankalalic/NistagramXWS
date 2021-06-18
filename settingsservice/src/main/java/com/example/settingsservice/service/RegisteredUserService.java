package com.example.settingsservice.service;

import com.example.settingsservice.dto.UserChangeDTO;
import com.example.settingsservice.model.RegisteredUser;
import com.example.settingsservice.model.UserRequest;
import com.example.settingsservice.repository.RegisteredUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisteredUserService {
    
    @Autowired
    private RegisteredUserRepository registeredUserRepository;


    public RegisteredUser changeRegisteredUserInfo(UserChangeDTO userChangeDTO){

        RegisteredUser registeredUser = registeredUserRepository.findOneById(3);

        registeredUser.setIme(userChangeDTO.getIme());
        registeredUser.seteMail(userChangeDTO.geteMail());
        registeredUser.setTelefon(userChangeDTO.getTelefon());
        registeredUser.setPol(userChangeDTO.getPol());
        registeredUser.setDatumrodj(userChangeDTO.getDatumrodj());
        registeredUser.setBiografija(userChangeDTO.getBiografija());
        registeredUser.setWebsajt(userChangeDTO.getWebsajt());
        registeredUser.setUsername(userChangeDTO.getUsername());

        this.registeredUserRepository.save(registeredUser);

        return registeredUser;

    }

    public RegisteredUser findByUsername(String username) {
        return registeredUserRepository.findByUsername(username);
    }

    public RegisteredUser save(UserRequest user) {
        RegisteredUser u = new RegisteredUser();
        u.setUsername(user.getUsername());
        u.setIme(user.getIme());
        u.setPrezime(user.getPrezime());
        u.seteMail(user.geteMail());
        u.setTelefon(user.getTelefon());
        u.setPol(user.getPol());
        u.setDatumrodj(user.getDatumrodj());
        u.setBiografija(user.getBiografija());
        u.setWebsajt(user.getWebsajt());
        // pre nego sto postavimo lozinku u atribut hesiramo je
        u.setLozinka(user.getLozinka());

        //List<Authority> auth = authService.findByname("ROLE_USER");
        // u primeru se registruju samo obicni korisnici i u skladu sa tim im se i dodeljuje samo rola USER
        //u.setAuthorities(auth);

        u = this.registeredUserRepository.save(u);
        return u;
    }
}
