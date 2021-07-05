package com.example.PostService.Controller;

import com.example.PostService.Model.*;
import com.example.PostService.Repository.AgentRepository;
import com.example.PostService.Repository.SlikaRepository;
import com.example.PostService.Service.PostService;
import com.example.PostService.Service.ReklamaService;
import com.example.PostService.Service.SadrzajService;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
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

    @CrossOrigin(origins = "http://localhost:8085")
    @PostMapping("/saveAll")
    public ListIntegerWrapper saveAll (@RequestBody ReklamaListDTO reklamaListDTO) throws IOException {
        List<Reklama> reklame = new ArrayList<>();

        for (ReklamaDTO reklamaDTO : reklamaListDTO.getReklamaDTOS()) {
            Reklama reklama = new Reklama();
            reklama.setKreator(agentRepository.findOneById(reklamaListDTO.getAgentId()));

            Set<Slika> slikeId = new HashSet<>();
            Integer slikaId = sadrzajService.upload(reklamaDTO.getSlika());
            Slika slika = slikaRepository.findOneById(slikaId);
            slikeId.add(slika);
            reklama.setSlike(slikeId);

            reklame.add(reklama);
        }
        List<Integer> integers = reklamaService.saveAll(reklame);
        ListIntegerWrapper listIntegerWrapper = new ListIntegerWrapper(integers);

        return listIntegerWrapper;
    }

}
