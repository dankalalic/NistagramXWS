package com.example.settingsservice.service;

import com.example.settingsservice.model.Agent;
import com.example.settingsservice.model.RegisteredUser;
import com.example.settingsservice.model.User;
import com.example.settingsservice.model.UserAndPrivacyDTO;
import com.example.settingsservice.repository.AgentRepository;
import com.example.settingsservice.repository.RegisteredUserRepository;
import com.example.settingsservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AgentRepository agentRepository;

    @Autowired
    private RegisteredUserRepository registeredUserRepository;


    public UserAndPrivacyDTO getUserById(Integer id) {
        User user = userRepository.findOneById(id);
        UserAndPrivacyDTO userAndPrivacyDTO = new UserAndPrivacyDTO();
        if (user.getDiscriminatorValue()=="agent") {
            Agent agent = agentRepository.findOneById(id);
            userAndPrivacyDTO.setId(user.getId());
            userAndPrivacyDTO.setIme(agent.getIme());
            userAndPrivacyDTO.setPrezime(agent.getPrezime());
            userAndPrivacyDTO.setLozinka(user.getLozinka());
            userAndPrivacyDTO.seteMail(agent.geteMail());
            userAndPrivacyDTO.setTelefon(agent.getTelefon());
            userAndPrivacyDTO.setPol(agent.getPol());
            userAndPrivacyDTO.setDatumrodj(agent.getDatumrodj());
            userAndPrivacyDTO.setBiografija(agent.getBiografija());
            userAndPrivacyDTO.setWebsajt(agent.getWebsajt());
            userAndPrivacyDTO.setUsername(agent.getUsername());
            userAndPrivacyDTO.setTaggable(agent.getDozvoljenoTagovanje());
            userAndPrivacyDTO.setAllowNotifs(agent.getDozvoljeneNotifikacije());
            userAndPrivacyDTO.setAcceptMsg(agent.getPrihvataPoruke());
            userAndPrivacyDTO.setIsp(agent.getIsPrivate());
        } else if (user.getDiscriminatorValue()=="user") {
            RegisteredUser agent = registeredUserRepository.findOneById(id);
            userAndPrivacyDTO.setId(user.getId());
            userAndPrivacyDTO.setIme(agent.getIme());
            userAndPrivacyDTO.setPrezime(agent.getPrezime());
            userAndPrivacyDTO.setLozinka(user.getLozinka());
            userAndPrivacyDTO.seteMail(agent.geteMail());
            userAndPrivacyDTO.setTelefon(agent.getTelefon());
            userAndPrivacyDTO.setPol(agent.getPol());
            userAndPrivacyDTO.setDatumrodj(agent.getDatumrodj());
            userAndPrivacyDTO.setBiografija(agent.getBiografija());
            userAndPrivacyDTO.setWebsajt(agent.getWebsajt());
            userAndPrivacyDTO.setUsername(agent.getUsername());
            userAndPrivacyDTO.setTaggable(agent.getDozvoljenoTagovanje());
            userAndPrivacyDTO.setAllowNotifs(agent.getDozvoljeneNotifikacije());
            userAndPrivacyDTO.setAcceptMsg(agent.getPrihvataPoruke());
            userAndPrivacyDTO.setIsp(agent.getIsPrivate());
        }
        return userAndPrivacyDTO;
    }
}
