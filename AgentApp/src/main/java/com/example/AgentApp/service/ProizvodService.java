package com.example.AgentApp.service;

import com.example.AgentApp.dto.ProizvodDto;
import com.example.AgentApp.model.Proizvod;
import com.example.AgentApp.repository.ProizvodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProizvodService {

    private ProizvodRepository proizvodRepository;

    @Autowired
    public void setProizvodRepository(ProizvodRepository proizvodRepository) {
        this.proizvodRepository = proizvodRepository;
    }

    public Proizvod create(ProizvodDto proizvodDto) {
        Proizvod proizvod =new Proizvod(proizvodDto.getCena(), proizvodDto.getRaspolozivoStanje(),proizvodDto.getSlika());

        return proizvod;
    }

    public Proizvod IzmenaProizvoda(ProizvodDto proizvodDto) {
        Proizvod proizvod=proizvodRepository.findOneById(proizvodDto.getId());
        proizvod.setCena(proizvodDto.getCena());
        proizvod.setSlika(proizvodDto.getSlika());
        proizvod.setRaspolozivoStanje(proizvodDto.getRaspolozivoStanje());
        proizvodRepository.save(proizvod);
        return proizvod;
    }

    public Proizvod findById(Integer id) { return proizvodRepository.findOneById(id);
    }
}
