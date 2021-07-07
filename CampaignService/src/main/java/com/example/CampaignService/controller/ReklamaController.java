package com.example.CampaignService.controller;

import com.example.CampaignService.TokenUtils;
import com.example.CampaignService.model.*;
import com.example.CampaignService.repository.AgentRepository;
import com.example.CampaignService.repository.KampanjaRepository;
import com.example.CampaignService.service.ReklamaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value="/reklame")
public class ReklamaController {

    @Autowired
    private RestTemplate restTemplate;


    @Autowired
    private ReklamaService reklamaService;

    @Autowired
    public TokenUtils tokenUtils;

    private KampanjaRepository kampanjaRepository;
    private AgentRepository agentRepository;

    @Autowired
    public void setSlikaRepository(KampanjaRepository kampanjaRepository) {
        this.kampanjaRepository = kampanjaRepository;
    }

    @Autowired
    public void agentRepository(AgentRepository agentRepository) {
        this.agentRepository = agentRepository;
    }



    @GetMapping(value="/getAllKampanje")
    public ResponseEntity<Set<SadrzajjDTO>> getAll(@RequestBody IdDTO idDTO){

        Integer userId = idDTO.getId();

        List<Agent> agenti= this.agentRepository.findAll();

        Set<Kampanja> kampanjas= new HashSet<Kampanja>();



        for (Agent agent: agenti){

            IdDoubleDTO idDoubleDTO= new IdDoubleDTO(userId, agent.getId());
            Boolean bool= restTemplate.postForObject("http://followeservice/follower/doIFollow",idDoubleDTO,Boolean.class);
            LocalDateTime now= LocalDateTime.now();
            Date now1= new Date();

            if (bool==true){
                Set<Kampanja> kampanje= agent.getKampanje();
                for (Kampanja kampanja: kampanje){
                    if (kampanja instanceof JednokratnaKampanja){



                        if ((now.isAfter(((JednokratnaKampanja) kampanja).getPocetakPrikazivanja())) && (now.isBefore(((JednokratnaKampanja) kampanja).getKrajPrikazivanja()))) {
                                kampanjas.add(kampanja);
                        }


                    }
                    if (kampanja instanceof VisekratnaKampanja){

                        if (now1.after(((VisekratnaKampanja) kampanja).getPocetakPrikazivanja())&&(now1.before(((VisekratnaKampanja) kampanja).getKrajPrikazivanja()))){

                            if (((VisekratnaKampanja) kampanja).getPotrebanBrojPrikazivanja()<=((VisekratnaKampanja) kampanja).getTrenutanBrojPrikazivanja()){
                                kampanjas.add(kampanja);
                            }
                            Integer brojprikazivanja= ((VisekratnaKampanja) kampanja).getTrenutanBrojPrikazivanja()+1;
                            ((VisekratnaKampanja) kampanja).setTrenutanBrojPrikazivanja(brojprikazivanja);
                            kampanjaRepository.save(kampanja);


                        }
                    }

                }


            }
            else{
                Set<Kampanja> kampanjee= agent.getKampanje();
                for (Kampanja kampanja: kampanjee) {
                    TargetGroupDTO targetGroupDTO= new TargetGroupDTO(userId, kampanja.getCiljnaGrupa().getGodinePocetka(),kampanja.getCiljnaGrupa().getGodineKraja());
                    Boolean bool1 = restTemplate.postForObject("http://authservice/users/targetAge", idDoubleDTO, Boolean.class);
                    if (bool1 == true) {
                        if (kampanja instanceof JednokratnaKampanja) {


                            if ((now.isAfter(((JednokratnaKampanja) kampanja).getPocetakPrikazivanja())) && (now.isBefore(((JednokratnaKampanja) kampanja).getKrajPrikazivanja()))) {

                                kampanjas.add(kampanja);
                            }


                        }
                        if (kampanja instanceof VisekratnaKampanja) {

                            if (now1.after(((VisekratnaKampanja) kampanja).getPocetakPrikazivanja()) && (now1.before(((VisekratnaKampanja) kampanja).getKrajPrikazivanja()))) {

                                if (((VisekratnaKampanja) kampanja).getPotrebanBrojPrikazivanja() <= ((VisekratnaKampanja) kampanja).getTrenutanBrojPrikazivanja()) {
                                    kampanjas.add(kampanja);
                                }
                                Integer brojprikazivanja = ((VisekratnaKampanja) kampanja).getTrenutanBrojPrikazivanja() + 1;
                                ((VisekratnaKampanja) kampanja).setTrenutanBrojPrikazivanja(brojprikazivanja);
                                kampanjaRepository.save(kampanja);


                            }
                        }

                    }

                }
            }

            }
        Set<SadrzajjDTO> sadrzajjDTOS= new HashSet<>();

        for (Kampanja kampanja: kampanjas){

            Set<Reklama> reklamas= kampanja.getReklame();



            for (Reklama reklama: reklamas){

                IdDTO idDTO1= new IdDTO(reklama.getId());

                SadrzajjDTO sadrzajjDTO = restTemplate.postForObject("http://postservice/sadrzaj/getReklamaById", idDTO1, SadrzajjDTO.class);

                sadrzajjDTOS.add(sadrzajjDTO);
            }

        }
        return new ResponseEntity<Set<SadrzajjDTO>>(sadrzajjDTOS, HttpStatus.OK);

        }





        }











