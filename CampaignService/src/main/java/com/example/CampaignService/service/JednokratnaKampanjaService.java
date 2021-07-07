package com.example.CampaignService.service;

import com.example.CampaignService.model.*;
import com.example.CampaignService.repository.AgentRepository;
import com.example.CampaignService.repository.CiljnaGrupaRepository;
import com.example.CampaignService.repository.JednokratnaKampanjaRepository;
import com.example.CampaignService.repository.ReklamaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class JednokratnaKampanjaService {

    @Autowired
    private JednokratnaKampanjaRepository jednokratnaKampanjaRepository;

    @Autowired
    private ReklamaRepository reklamaRepository;

    @Autowired
    private AgentRepository agentRepository;

    @Autowired
    private CiljnaGrupaRepository ciljnaGrupaRepository;

    @Autowired
    private RestTemplate restTemplate;

    public JednokratnaKampanja saveKampanja(JednokratnaDTO jednokratnaDTO, Integer id) {
        JednokratnaKampanja kampanja = new JednokratnaKampanja();

        CiljnaGrupa ciljnaGrupa = new CiljnaGrupa();
        if (ciljnaGrupaRepository.findByPolAndGodinePocetkaAndGodineKraja(jednokratnaDTO.getPol(), jednokratnaDTO.getGodinePocetka(), jednokratnaDTO.getGodineKraja()) == null) {
            ciljnaGrupa.setPol(jednokratnaDTO.getPol());
            ciljnaGrupa.setGodinePocetka(jednokratnaDTO.getGodinePocetka());
            ciljnaGrupa.setGodineKraja(jednokratnaDTO.getGodineKraja());
            ciljnaGrupaRepository.save(ciljnaGrupa);
        } else {
            ciljnaGrupa = ciljnaGrupaRepository.findByPolAndGodinePocetkaAndGodineKraja(jednokratnaDTO.getPol(), jednokratnaDTO.getGodinePocetka(), jednokratnaDTO.getGodineKraja());
        }

        kampanja.setCiljnaGrupa(ciljnaGrupa);

        String url="http://postservice/reklame/saveAll";

        //UserDTO userDTO = new UserDTO(id, id2);
        ReklamaListDTO reklamaListDTO = new ReklamaListDTO();
        reklamaListDTO.setAgentId(id);

        int counter = 0;
        List<ReklamaDTO> reklamaDTOs = new ArrayList<>();
        for (Slika slika : jednokratnaDTO.getSlike()) {
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

        //kampanja.setReklame(reklamas);


        Agent agent = agentRepository.findOneById(id);
        kampanja.setAgent(agent);
        kampanja.setReklame(reklamas);
        kampanja.setPocetakPrikazivanja(jednokratnaDTO.getPocetakPrikazivanja());
        kampanja.setKrajPrikazivanja(jednokratnaDTO.getKrajPrikazivanja());


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

        Set<Kampanja> kampanjas=agent.getKampanje();
        kampanjas.add(kampanja);
        agent.setKampanje(kampanjas);
        //  agentRepository.save(agent);

        kampanja=jednokratnaKampanjaRepository.save(kampanja);

        return kampanja;
    }

    public List<KampanjaReturnDTO> getAllByAgent(Agent agent) {
        List<JednokratnaKampanja> kampanje = jednokratnaKampanjaRepository.getAllByAgent(agent);
        List<JednokratnaDTO> jednokratnaDTOS = new ArrayList<>();

        List<Integer> integers = new ArrayList<>();
        List<Integer> numOfReklamasPerKampanjaList = new ArrayList<>();
        for (JednokratnaKampanja jednokratnaKampanja : kampanje) {
            Integer numOfReklamasPerKampanja = 0;
            for (Reklama reklama : jednokratnaKampanja.getReklame()) {
                integers.add(reklama.getId());
                numOfReklamasPerKampanja++;
            }
            numOfReklamasPerKampanjaList.add(numOfReklamasPerKampanja);
        }

        ListIntegerWrapper listIntegerWrapper = new ListIntegerWrapper(integers);
        String url="http://postservice/reklame/getAll";
        KampanjaReturnDTO kampanjaReturnDTO = restTemplate.postForObject(url,listIntegerWrapper, KampanjaReturnDTO.class);
        /*List<Slika> slike = new ArrayList<>();
        for(ReklamaReturnDTO reklamaReturnDTO : kampanjaReturnDTO.getReklame()) {
            slike.addAll(reklamaReturnDTO.getSlike());
        }*/

        List<KampanjaReturnDTO> kampanjaReturnDTOS = new ArrayList<>();
        int counter = 0;
        int start = 0;
        for (JednokratnaKampanja kampanja : kampanje) {
            KampanjaReturnDTO kampanjaReturnDTO1 = new KampanjaReturnDTO();
            kampanjaReturnDTO1.setReklame(kampanjaReturnDTO.getReklame().subList(start, start+numOfReklamasPerKampanjaList.get(counter)));
            kampanjaReturnDTO1.setCiljnaGrupa(kampanja.getCiljnaGrupa());
            kampanjaReturnDTO1.setPocetakPrikazivanja(kampanja.getPocetakPrikazivanja());
            kampanjaReturnDTO1.setKrajPrikazivanja(kampanja.getKrajPrikazivanja());
            kampanjaReturnDTO1.setLajkovali(kampanjaReturnDTO.getLajkovali());
            kampanjaReturnDTO1.setDislajkovali(kampanjaReturnDTO.getDislajkovali());
            kampanjaReturnDTO1.setId(kampanja.getId());

            kampanjaReturnDTOS.add(kampanjaReturnDTO1);
            start += numOfReklamasPerKampanjaList.get(counter);
            counter++;
        }

        return kampanjaReturnDTOS;
    }

    public JednokratnaKampanja changeKampanja(JednokratnaDTO jednokratnaDTO) {
        JednokratnaKampanja kampanja = jednokratnaKampanjaRepository.findOneById(jednokratnaDTO.getId());
        CiljnaGrupa ciljnaGrupa = new CiljnaGrupa();
        if (ciljnaGrupaRepository.findByPolAndGodinePocetkaAndGodineKraja(jednokratnaDTO.getPol(), jednokratnaDTO.getGodinePocetka(), jednokratnaDTO.getGodineKraja()) == null) {
            ciljnaGrupa.setPol(jednokratnaDTO.getPol());
            ciljnaGrupa.setGodinePocetka(jednokratnaDTO.getGodinePocetka());
            ciljnaGrupa.setGodineKraja(jednokratnaDTO.getGodineKraja());
            ciljnaGrupaRepository.save(ciljnaGrupa);
        } else {
            ciljnaGrupa = ciljnaGrupaRepository.findByPolAndGodinePocetkaAndGodineKraja(jednokratnaDTO.getPol(), jednokratnaDTO.getGodinePocetka(), jednokratnaDTO.getGodineKraja());
        }
        kampanja.setCiljnaGrupa(ciljnaGrupa);
        kampanja.setPocetakPrikazivanja(jednokratnaDTO.getPocetakPrikazivanja());
        kampanja.setKrajPrikazivanja(jednokratnaDTO.getKrajPrikazivanja());

        return jednokratnaKampanjaRepository.save(kampanja);

    }

    public void deleteKampanja(IdDTO idDTO) {
        jednokratnaKampanjaRepository.deleteById(idDTO.getId());
    }

}
