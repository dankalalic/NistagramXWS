package com.example.CampaignService.controller;

import com.example.CampaignService.TokenUtils;
import com.example.CampaignService.model.IdDTO;
import com.example.CampaignService.model.JednokratnaDTO;
import com.example.CampaignService.model.JednokratnaKampanja;
import com.example.CampaignService.model.KampanjaReturnDTO;
import com.example.CampaignService.repository.AgentRepository;
import com.example.CampaignService.service.JednokratnaKampanjaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value="/jednokratneKampanje")
public class JednokratnaKampanjaController {

    @Autowired
    private JednokratnaKampanjaService jednokratnaKampanjaService;

    @Autowired
    private TokenUtils tokenUtils;

    @Autowired
    private AgentRepository agentRepository;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/create")
    public ResponseEntity<JednokratnaKampanja> create(@RequestBody JednokratnaDTO jednokratnaDTO, @RequestHeader(value="Authorization") String token) throws Exception {
        String role = tokenUtils.getRoleFromToken(token);
        if (role.equals("agent")) {
            Integer userId = tokenUtils.getIdFromToken(token);
            return new ResponseEntity<>(jednokratnaKampanjaService.saveKampanja(jednokratnaDTO, userId), HttpStatus.OK);
        } else {
            throw new Exception("Zabranjeno");
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getAll")
    public ResponseEntity<List<KampanjaReturnDTO>> getAll(@RequestHeader(value="Authorization") String token) throws Exception {
        String role = tokenUtils.getRoleFromToken(token);
        if (role.equals("agent")) {
            Integer userId = tokenUtils.getIdFromToken(token);
            return new ResponseEntity<>(jednokratnaKampanjaService.getAllByAgent(agentRepository.findOneById(userId)), HttpStatus.OK);
        } else {
            throw new Exception("Zabranjeno");
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/change")
    public ResponseEntity<JednokratnaKampanja> changeKampanja(@RequestBody JednokratnaDTO jednokratnaDTO, @RequestHeader(value="Authorization") String token) throws Exception {
        String role = tokenUtils.getRoleFromToken(token);
        if (role.equals("agent")) {
            Integer userId = tokenUtils.getIdFromToken(token);
            return new ResponseEntity<>(jednokratnaKampanjaService.changeKampanja(jednokratnaDTO), HttpStatus.OK);
        } else {
            throw new Exception("Zabranjeno");
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/delete")
    public void deleteKampanja(@RequestBody IdDTO idDTO, @RequestHeader(value="Authorization") String token) throws Exception {
        String role = tokenUtils.getRoleFromToken(token);
        if (role.equals("agent")) {
            Integer userId = tokenUtils.getIdFromToken(token);
            jednokratnaKampanjaService.deleteKampanja(idDTO);
        } else {
            throw new Exception("Zabranjeno");
        }
    }
}
