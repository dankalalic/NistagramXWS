package com.example.PostService.Service;

import com.example.PostService.Model.Reklama;
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

}
