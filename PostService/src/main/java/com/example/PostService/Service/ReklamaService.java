package com.example.PostService.Service;

import com.example.PostService.Model.*;
import com.example.PostService.Repository.ReklamaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReklamaService {

    @Autowired
    private ReklamaRepository reklamaRepository;

    public List<Integer> saveAll(List<Reklama> reklame) {
        List<Reklama> reklameSaved = reklamaRepository.saveAll(reklame);
        List<Integer> reklameIds = new ArrayList<>();
        for (Reklama reklama : reklameSaved) {
            reklameIds.add(reklama.getId());
        }

        return reklameIds;
    }

    public Integer save(Reklama reklama) {
        Reklama reklama1 = reklamaRepository.save(reklama);
        return reklama1.getId();
    }

    public KampanjaReturnDTO getReklameById(List<Integer> ids) {
        List<ReklamaReturnDTO> reklame = new ArrayList<>();
        for (Integer id : ids) {
            Reklama reklama = reklamaRepository.findOneById(id);
            Integer lajkovali = 0; Integer dislajkovali = 0;
            for (RegistrovaniKorisnik lajkovao : reklama.getLajkovali()) {
                lajkovali++;
            }
            for (RegistrovaniKorisnik dislajkovao : reklama.getDislajkovali()) {
                dislajkovali++;
            }
            ReklamaReturnDTO reklamaReturnDTO = new ReklamaReturnDTO(reklama.getSlike(), lajkovali, dislajkovali);
            reklame.add(reklamaReturnDTO);
        }
        return new KampanjaReturnDTO(reklame);
    }
}
