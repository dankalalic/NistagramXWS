package com.example.PostService.Controller;

import com.example.PostService.Model.*;
import com.example.PostService.Repository.AgentRepository;
import com.example.PostService.Repository.SlikaRepository;
import com.example.PostService.Service.ReklamaService;
import com.example.PostService.Service.SadrzajService;
import com.example.PostService.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value="/reklame")
public class ReklamaController {

    @Autowired
    private ReklamaService reklamaService;

    @Autowired
    private AgentRepository agentRepository;

    @Autowired
    private SadrzajService sadrzajService;

    @Autowired
    private SlikaRepository slikaRepository;

    @Autowired
    private TokenUtils tokenUtils;

    @CrossOrigin(origins = "http://localhost:8085")
    @PostMapping("/saveAll")
    public ListIntegerWrapper saveAll (@RequestBody ReklamaListDTO reklamaListDTO, @RequestHeader(value="Authorization") String token) throws Exception {
        String role = tokenUtils.getRoleFromToken(token);
        if (role.equals("agent")) {


            List<Reklama> reklamas = new ArrayList<>();
            List<Integer> integers = new ArrayList<>();
            Agent agent = agentRepository.findOneById(reklamaListDTO.getAgentId());

            for (ReklamaDTO reklamaDTO : reklamaListDTO.getReklamaDTOS()) {
                Reklama reklama = new Reklama();
                reklama.setReklama(true);

                reklama.setKreator(agentRepository.findOneById(reklamaListDTO.getAgentId()));

                Set<Slika> slike = new HashSet<>();
                slike.add(reklamaDTO.getSlika());

                slikaRepository.saveAll(slike);
                reklama.setSlike(slike);

                Integer reklamaId = reklamaService.save(reklama);
                for (Slika slika : slike) {
                    slika.setSadrzaj(reklama);
                    slikaRepository.save(slika);
                }

                integers.add(reklamaId);
                reklamas.add(reklama);
            }

            Set<Reklama> reklame = agent.getReklame();
            reklame.addAll(reklamas);
            agent.setReklame(reklame);
            agentRepository.save(agent);

            return new ListIntegerWrapper(integers);
        } else {
            throw new Exception("Zabranjeno");
        }
    }

    @CrossOrigin(origins = "http://localhost:8085")
    @PostMapping("/getAll")
    public KampanjaReturnDTO getByIds (@RequestBody ListIntegerWrapper integers, @RequestHeader(value="Authorization") String token) throws Exception {
        String role = tokenUtils.getRoleFromToken(token);
        if (role.equals("agent")) {
            Integer userId = tokenUtils.getIdFromToken(token);
            return reklamaService.getReklameById(integers.getIntegerList());
        } else {
            throw new Exception("Zabranjeno");
        }
    }
}
