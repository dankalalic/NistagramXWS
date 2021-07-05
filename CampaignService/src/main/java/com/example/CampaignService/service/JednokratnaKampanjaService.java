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
import java.util.List;

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
        } else {
            ciljnaGrupa = ciljnaGrupaRepository.findByPolAndGodinePocetkaAndGodineKraja(jednokratnaDTO.getPol(), jednokratnaDTO.getGodinePocetka(), jednokratnaDTO.getGodineKraja());
        }

        kampanja.setCiljnaGrupa(ciljnaGrupa);
        kampanja.setAgent(agentRepository.findOneById(id));

        String url="http://postservice/reklame/saveAll";

        //UserDTO userDTO = new UserDTO(id, id2);
        ReklamaListDTO reklamaListDTO = new ReklamaListDTO();
        reklamaListDTO.setAgentId(id);

        int counter = 0;
        List<ReklamaDTO> reklamaDTOs = new ArrayList<>();
        for (MultipartFile multipartFile : jednokratnaDTO.getSlike()) {
            ReklamaDTO reklamaDTO = new ReklamaDTO(multipartFile, jednokratnaDTO.getLinkovi().get(counter));
            counter++;
            reklamaDTOs.add(reklamaDTO);
        }

        reklamaListDTO.setReklamaDTOS(reklamaDTOs);
        ListIntegerWrapper reklameIds = restTemplate.postForObject(url,reklamaListDTO, ListIntegerWrapper.class);

        counter = 0;
        for (Integer reklamaId : reklameIds.getIntegerList()) {
            Reklama reklama = new Reklama(reklamaId, jednokratnaDTO.getLinkovi().get(counter));
            counter++;
            reklamaRepository.save(reklama);
        }

        return jednokratnaKampanjaRepository.save(kampanja);
    }
}
