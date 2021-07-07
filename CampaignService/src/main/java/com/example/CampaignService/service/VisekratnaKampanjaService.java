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
            //reklamaRepository.save(reklama);
            reklamas.add(reklama);
        }
        Agent agent = agentRepository.findOneById(id);
        kampanja.setAgent(agent);
        kampanja.setReklame(reklamas);
        kampanja.setPocetakPrikazivanja(visekratnaDTO.getPocetakPrikazivanja());
        kampanja.setKrajPrikazivanja(visekratnaDTO.getKrajPrikazivanja());
        kampanja.setPotrebanBrojPrikazivanja(visekratnaDTO.getPotrebanBrojPrikazivanja());
        kampanja.setTrenutanBrojPrikazivanja(0);

        for (Reklama reklama : reklamas) {
            reklama.setKampanja(kampanja);
        }

        Set<Kampanja> kampanjas=agent.getKampanje();
        kampanjas.add(kampanja);
        agent.setKampanje(kampanjas);
        //  agentRepository.save(agent);

        kampanja=visekratnaKampanjaRepository.save(kampanja);

        return kampanja;
    }

    public List<KampanjaReturnDTO> getAllByAgent(Agent agent) {
        List<VisekratnaKampanja> kampanje = visekratnaKampanjaRepository.getAllByAgent(agent);
        List<VisekratnaDTO> visekratnaDTOS = new ArrayList<>();

        List<Integer> integers = new ArrayList<>();
        List<Integer> numOfReklamasPerKampanjaList = new ArrayList<>();
        for (VisekratnaKampanja visekratnaKampanja : kampanje) {
            Integer numOfReklamasPerKampanja = 0;
            for (Reklama reklama : visekratnaKampanja.getReklame()) {
                integers.add(reklama.getId());
                numOfReklamasPerKampanja++;
            }
            numOfReklamasPerKampanjaList.add(numOfReklamasPerKampanja);
        }

        ListIntegerWrapper listIntegerWrapper = new ListIntegerWrapper(integers);
        String url="http://postservice/reklame/getAll";
        KampanjaReturnDTO kampanjaReturnDTO = restTemplate.postForObject(url,listIntegerWrapper, KampanjaReturnDTO.class);

        List<KampanjaReturnDTO> kampanjaReturnDTOS = new ArrayList<>();
        int counter = 0;
        int start = 0;
        for (VisekratnaKampanja kampanja : kampanje) {
            KampanjaReturnDTO kampanjaReturnDTO1 = new KampanjaReturnDTO();
            kampanjaReturnDTO1.setReklame(kampanjaReturnDTO.getReklame().subList(start, start+numOfReklamasPerKampanjaList.get(counter)));
            kampanjaReturnDTO1.setCiljnaGrupa(kampanja.getCiljnaGrupa());
            kampanjaReturnDTO1.setPocetakPrikazivanja1(kampanja.getPocetakPrikazivanja());
            kampanjaReturnDTO1.setKrajPrikazivanja1(kampanja.getKrajPrikazivanja());
            kampanjaReturnDTO1.setPotrebanBrojPrikazivanja(kampanja.getPotrebanBrojPrikazivanja());
            kampanjaReturnDTO1.setLajkovali(kampanjaReturnDTO.getLajkovali());
            kampanjaReturnDTO1.setDislajkovali(kampanjaReturnDTO.getDislajkovali());
            kampanjaReturnDTO1.setId(kampanja.getId());

            kampanjaReturnDTOS.add(kampanjaReturnDTO1);
            start += numOfReklamasPerKampanjaList.get(counter);
            counter++;
        }

        return kampanjaReturnDTOS;
    }

    public VisekratnaKampanja changeKampanja(VisekratnaDTO visekratnaDTO) {
        VisekratnaKampanja kampanja = visekratnaKampanjaRepository.findOneById(visekratnaDTO.getId());
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
        kampanja.setPocetakPrikazivanja(visekratnaDTO.getPocetakPrikazivanja());
        kampanja.setKrajPrikazivanja(visekratnaDTO.getKrajPrikazivanja());
        kampanja.setPotrebanBrojPrikazivanja(visekratnaDTO.getPotrebanBrojPrikazivanja());

        return visekratnaKampanjaRepository.save(kampanja);
    }

    public void deleteKampanja(IdDTO idDTO) {
        visekratnaKampanjaRepository.deleteById(idDTO.getId());
    }

}
