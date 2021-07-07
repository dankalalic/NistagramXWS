package com.example.AgentApp.service;

import com.example.AgentApp.dto.ProizvodDto;
import com.example.AgentApp.model.Proizvod;
import com.example.AgentApp.model.Slika;
import com.example.AgentApp.repository.AgentRepository;
import com.example.AgentApp.repository.ProizvodRepository;
import com.example.AgentApp.repository.SlikaRepository;
import org.springframework.aop.target.LazyInitTargetSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProizvodService {

    private ProizvodRepository proizvodRepository;

    @Autowired
    public void setProizvodRepository(ProizvodRepository proizvodRepository) {
        this.proizvodRepository = proizvodRepository;
    }

    @Autowired
    private AgentRepository agentRepository;

    @Autowired
    private SlikaRepository slikaRepository;

    public Proizvod create(ProizvodDto proizvodDto) {
        Proizvod proizvod =new Proizvod();
        proizvod.setCena(proizvodDto.getCena());
        proizvod.setRaspolozivoStanje(proizvodDto.getRaspolozivoStanje());
        proizvod.setSlika(slikaRepository.findOneById(proizvodDto.getSlika()));

        return proizvod;
    }

    public Proizvod IzmenaProizvoda(ProizvodDto proizvodDto) {
        Proizvod proizvod=proizvodRepository.findOneById(proizvodDto.getId());
        proizvod.setCena(proizvodDto.getCena());
        //proizvod.setSlika(proizvodDto.getSlika());
        proizvod.setRaspolozivoStanje(proizvodDto.getRaspolozivoStanje());
        proizvod.setNaziv(proizvodDto.getNaziv());
        proizvodRepository.save(proizvod);
        return proizvod;
    }

    public Proizvod findById(Integer id) { return proizvodRepository.findOneById(id);
    }

    public List<Proizvod> findByAgent(Integer id) {
        return proizvodRepository.findByAgent(agentRepository.findOneById(id));
    }

}
