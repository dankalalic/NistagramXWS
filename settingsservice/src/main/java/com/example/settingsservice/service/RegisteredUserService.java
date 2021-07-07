package com.example.settingsservice.service;

import com.example.settingsservice.dto.UserChangeDTO;
import com.example.settingsservice.model.RegisteredUser;
import com.example.settingsservice.model.UserRequest;
import com.example.settingsservice.repository.RegisteredUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class RegisteredUserService {
    
    @Autowired
    private RegisteredUserRepository registeredUserRepository;


    public RegisteredUser changeRegisteredUserInfo(UserChangeDTO userChangeDTO, Integer id){

        RegisteredUser registeredUser = registeredUserRepository.findOneById(id);

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

    public RegisteredUser privacyAndNotificationSettings(Integer id, Boolean taggable, Boolean isPrivate, Boolean acceptMsg, Boolean allowNotifs) {
        RegisteredUser registeredUser = registeredUserRepository.findOneById(id);

        registeredUser.setDozvoljeneNotifikacije(allowNotifs);
        registeredUser.setDozvoljenoTagovanje(taggable);
        registeredUser.setIsPrivate(isPrivate);
        registeredUser.setPrihvataPoruke(acceptMsg);

        return registeredUserRepository.save(registeredUser);
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
        u.setEnabled(true);
        // pre nego sto postavimo lozinku u atribut hesiramo je
        u.setLozinka(user.getLozinka());

        //List<Authority> auth = authService.findByname("ROLE_USER");
        // u primeru se registruju samo obicni korisnici i u skladu sa tim im se i dodeljuje samo rola USER
        //u.setAuthorities(auth);

        u = this.registeredUserRepository.save(u);
        return u;
    }

    public RegisteredUser block(Integer idToBlock, Integer idBlocker) {
        RegisteredUser blocker = registeredUserRepository.findOneById(idBlocker);
        RegisteredUser toBlock = registeredUserRepository.findOneById(idToBlock);

        Set<RegisteredUser> blokirani = blocker.getJaBlokirao();
        Set<RegisteredUser> meneBlokirali = toBlock.getMeneBlokirali();

        blokirani.add(toBlock);
        meneBlokirali.add(blocker);

        blocker.setJaBlokirao(blokirani);
        toBlock.setMeneBlokirali(meneBlokirali);

        registeredUserRepository.save(toBlock);
        return registeredUserRepository.save(blocker);
    }
}
