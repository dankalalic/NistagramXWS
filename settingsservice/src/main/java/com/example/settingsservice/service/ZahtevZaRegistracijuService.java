package com.example.settingsservice.service;

import com.example.settingsservice.model.*;
import com.example.settingsservice.repository.AdminRepository;
import com.example.settingsservice.repository.AgentRepository;
import com.example.settingsservice.repository.RegisteredUserRepository;
import com.example.settingsservice.repository.ZahtevZaRegistracijuRepository;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ZahtevZaRegistracijuService {

    @Autowired
    private ZahtevZaRegistracijuRepository zahtevZaRegistracijuRepository;

    @Autowired
    private RegisteredUserRepository registeredUserRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private AgentRepository agentRepository;

    public StringDTO regAgent(regAgentDTO regAgentDTO, Integer userId){
        RegisteredUser registeredUser = registeredUserRepository.findOneById(userId);
        //Admin admin = adminRepository.findOneById(1);

        registeredUser.setWebsajt(regAgentDTO.getWebsajt());
        registeredUser.seteMail(regAgentDTO.getEmail());
        registeredUserRepository.save(registeredUser);

        ZahtevZaRegistraciju zahtevZaRegistraciju = new ZahtevZaRegistraciju();
        //zahtevZaRegistraciju.setAdmin(admin);
        zahtevZaRegistraciju.setRegisteredUser(registeredUser);
        zahtevZaRegistraciju.setOdobren(false);
        zahtevZaRegistracijuRepository.save(zahtevZaRegistraciju);

        String s = "Uspesno ste poslali zahtev";
        StringDTO stringDTO = new StringDTO(s);
        return stringDTO;

    }

    public Set<ZahteviReturnDTO> getZahteve(){
        List<ZahtevZaRegistraciju> zahtevZaRegistracijuList = zahtevZaRegistracijuRepository.findAll();

        Set<ZahteviReturnDTO> returnDTO = new HashSet<>();

        for (ZahtevZaRegistraciju zahtev:zahtevZaRegistracijuList) {
            if(zahtev.getOdobren().equals(false)) {
                ZahteviReturnDTO zahteviReturnDTO = new ZahteviReturnDTO();
                zahteviReturnDTO.setId(zahtev.getRegisteredUser().getId());
                zahteviReturnDTO.setIme(zahtev.getRegisteredUser().getIme());
                zahteviReturnDTO.setPrezime(zahtev.getRegisteredUser().getPrezime());
                zahteviReturnDTO.setUsername(zahtev.getRegisteredUser().getUsername());
                zahteviReturnDTO.setEmail(zahtev.getRegisteredUser().geteMail());
                zahteviReturnDTO.setWebsajt(zahtev.getRegisteredUser().getWebsajt());

                returnDTO.add(zahteviReturnDTO);
            }
        }

        return returnDTO;

    }

    public StringDTO prihvati(IdOnlyDTO idOnlyDTO, Integer userId){
        Admin admin = adminRepository.findOneById(userId);
        RegisteredUser user = registeredUserRepository.findOneById(idOnlyDTO.getId());

        user.setEnabled(false);
        user.seteMail(user.geteMail()+'1');
        user.setUsername(user.getUsername()+'1');
        registeredUserRepository.save(user);

        Agent u = new Agent();

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
        u.setLozinka(user.getLozinka());
        u.setDatumrodj(user.getDatumrodj());

        this.agentRepository.save(u);

        ZahtevZaRegistraciju zahtevZaRegistraciju = zahtevZaRegistracijuRepository.findOneByRegisteredUser(user);
        zahtevZaRegistraciju.setOdobren(true);
        zahtevZaRegistraciju.setAdmin(admin);
        /*Set<ZahtevZaRegistraciju> zahteviAdmina = admin.getZahteviZaRegistraciju();
        zahteviAdmina.add(zahtevZaRegistraciju);
        admin.setZahteviZaRegistraciju(zahteviAdmina);*/
        this.zahtevZaRegistracijuRepository.save(zahtevZaRegistraciju);

        String s = "Uspesno ste prihvatili zahtev";
        StringDTO stringDTO = new StringDTO(s);
        return stringDTO;

    }

    public StringDTO odbij(IdOnlyDTO idOnlyDTO, Integer userId){

        RegisteredUser registeredUser = registeredUserRepository.findOneById(idOnlyDTO.getId());
        ZahtevZaRegistraciju zahtevZaRegistraciju = zahtevZaRegistracijuRepository.findOneByRegisteredUser(registeredUser);

        this.zahtevZaRegistracijuRepository.delete(zahtevZaRegistraciju);

        String s = "Uspesno ste odbili zahtev";
        StringDTO stringDTO = new StringDTO(s);
        return stringDTO;


    }
}
