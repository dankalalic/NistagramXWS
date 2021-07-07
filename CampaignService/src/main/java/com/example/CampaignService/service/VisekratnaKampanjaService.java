package com.example.CampaignService.service;

import com.example.CampaignService.model.*;
import com.example.CampaignService.repository.AgentRepository;
import com.example.CampaignService.repository.CiljnaGrupaRepository;
import com.example.CampaignService.repository.ReklamaRepository;
import com.example.CampaignService.repository.VisekratnaKampanjaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class VisekratnaKampanjaService {

    @Autowired
    private VisekratnaKampanjaRepository visekratnaKampanjaRepository;

    @Autowired
    private ReklamaRepository reklamaRepository;

    @Autowired
    private AgentRepository agentRepository;

    @Autowired
    private CiljnaGrupaRepository ciljnaGrupaRepository;

    @Autowired
    private RestTemplate restTemplate;

    public VisekratnaKampanja saveKampanja(VisekratnaDTO visekratnaDTO, Integer id) {
        VisekratnaKampanja kampanja = new VisekratnaKampanja();

        CiljnaGrupa ciljnaGrupa = new CiljnaGrupa();
        if (ciljnaGrupaRepository.findByPolAndGodinePocetkaAndGodineKraja(visekratnaDTO.getPol(), visekratnaDTO.getGodinePocetka(), visekratnaDTO.getGodineKraja()) == null) {
            ciljnaGrupa.setPol(visekratnaDTO.getPol());
            ciljnaGrupa.setGodinePocetka(visekratnaDTO.getGodinePocetka());
            ciljnaGrupa.setGodineKraja(visekratnaDTO.getGodineKraja());
            ciljnaGrupaRepository.save(ciljnaGrupa);
        } else {
            ciljnaGrupa = ciljnaGrupaRepository.findByPolAndGodinePocetkaAndGodineKraja(visekratnaDTO.getPol(), visekratnaDTO.getGodinePocetka(), visekratnaDTO.getGodineKraja());
        }

        kampanja.setCiljnaGrupa(ciljnaGrupa);

        String url="http://postservice/reklame/saveAll";

        //UserDTO userDTO = new UserDTO(id, id2);
        ReklamaListDTO reklamaListDTO = new ReklamaListDTO();
        reklamaListDTO.setAgentId(id);

        int counter = 0;
        List<ReklamaDTO> reklamaDTOs = new ArrayList<>();
        for (Slika slika : visekratnaDTO.getSlike()) {
            //ReklamaDTO reklamaDTO = new ReklamaDTO(slika, jednokratnaDTO.getLinkovi().get(counter));
            ReklamaDTO reklamaDTO = new ReklamaDTO(slika, "g");
            counter++;
            reklamaDTOs.add(reklamaDTO);
        }

        reklamaListDTO.setReklamaDTOS(reklamaDTOs);
        reklamaListDTO.setAgentId(id);
        ListIntegerWrapper reklameIds = restTemplate.postForObject(url,reklamaListDTO, ListIntegerWrapper.class);

        Set<Reklama> reklamas = new HashSet<>();
        counter = 0;
        for (Integer reklamaId : reklameIds.getIntegerList()) {
            //Reklama reklama = new Reklama(reklamaId, jednokratnaDTO.getLinkovi().get(counter));
            Reklama reklama = new Reklama(reklamaId, "g");
            counter++;
            reklamaRepository.save(reklama);
            reklamas.add(reklama);
        }

        Agent agent = agentRepository.findOneById(id);
        kampanja.setAgent(agent);
        kampanja.setReklame(reklamas);

        //JednokratnaKampanja jednokratnaKampanja = jednokratnaKampanjaRepository.save(kampanja);
        //Set<Kampanja> kampanje = agent.getKampanje();
        //kampanje.add(kampanja);
        //agent.setKampanje(kampanje);
        //agentRepository.save(agent);

        //set kampanja id in reklama
        for (Reklama reklama : reklamas) {
            reklama.setKampanja(kampanja);
            //reklamaRepository.save(reklama);
        }

        return visekratnaKampanjaRepository.save(kampanja);
    }

    public List<VisekratnaKampanja> getAllByAgent(Agent agent) {
         List<VisekratnaKampanja> kampanje = visekratnaKampanjaRepository.getAllByAgent(agent);
         List<VisekratnaDTO> visekratnaDTOS = new ArrayList<>();

         List<Integer> integers = new ArrayList<>();
         for (VisekratnaKampanja visekratnaKampanja : kampanje) {
             for (Reklama reklama : visekratnaKampanja.getReklame()) {
                 integers.add(reklama.getId());
             }
         }

         ListIntegerWrapper listIntegerWrapper = new ListIntegerWrapper(integers);
         String url="http://postservice/reklame/getAll";
         KampanjaReturnDTO kampanjaReturnDTO = restTemplate.postForObject(url,listIntegerWrapper, KampanjaReturnDTO.class);
         List<Slika> slike = new ArrayList<>();
         for(ReklamaReturnDTO reklamaReturnDTO : kampanjaReturnDTO.getReklame()) {
             slike.addAll(reklamaReturnDTO.getSlike());
         }

         for (VisekratnaKampanja kampanja : kampanje) {
             VisekratnaDTO visekratnaDTO = new VisekratnaDTO();
             visekratnaDTO.setPol(kampanja.getCiljnaGrupa().getPol());
             visekratnaDTO.setGodinePocetka(kampanja.getCiljnaGrupa().getGodinePocetka());
             visekratnaDTO.setGodineKraja(kampanja.getCiljnaGrupa().getGodineKraja());
             visekratnaDTO.setSlike(slike);
             visekratnaDTO.setPocetakPrikazivanja(kampanja.getPocetakPrikazivanja());
             visekratnaDTO.setKrajPrikazivanja(kampanja.getKrajPrikazivanja());
             visekratnaDTO.setPotrebanBrojPrikazivanja(kampanja.getPotrebanBrojPrikazivanja());
         }

        return kampanje;
    }
}
