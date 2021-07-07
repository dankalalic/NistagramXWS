package com.example.CampaignService.controller;

import com.example.CampaignService.TokenUtils;
import com.example.CampaignService.model.*;
import com.example.CampaignService.repository.AgentRepository;
import com.example.CampaignService.service.VisekratnaKampanjaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value="/visekratneKampanja")
public class VisekratnaKampanjaController {

    @Autowired
    private VisekratnaKampanjaService visekratnaKampanjaService;

    @Autowired
    private TokenUtils tokenUtils;

    @Autowired
    private AgentRepository agentRepository;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/create")
    public VisekratnaKampanja create(@RequestBody VisekratnaDTO visekratnaDTO, @RequestHeader(value="Authorization") String token) throws Exception {
        String role = tokenUtils.getRoleFromToken(token);
        if (role.equals("agent")) {
            Integer userId = tokenUtils.getIdFromToken(token);
            return visekratnaKampanjaService.saveKampanja(visekratnaDTO, userId);
        } else {
            throw new Exception("Zabranjeno");
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getAll")
    public List<KampanjaReturnDTO> getAll(@RequestHeader(value="Authorization") String token) {
        Integer userId = tokenUtils.getIdFromToken(token);
        return visekratnaKampanjaService.getAllByAgent(agentRepository.findOneById(userId));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/change")
    public ResponseEntity<VisekratnaKampanja> changeKampanja(@RequestBody VisekratnaDTO visekratnaDTO) {
        return new ResponseEntity<>(visekratnaKampanjaService.changeKampanja(visekratnaDTO), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/delete")
    public void deleteKampanja(@RequestBody IdDTO idDTO) {
        visekratnaKampanjaService.deleteKampanja(idDTO);
    }

}
