package com.example.PostService.Repository;

import com.example.PostService.Model.Agent;
import com.example.PostService.Model.Lokacija;
import com.example.PostService.Model.Reklama;
import com.example.PostService.Model.Tagovi;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReklamaRepository extends JpaRepository<Reklama, Integer> {

    Reklama findOneById(Integer id);

    List<Reklama> findByLokacija(Lokacija lokacija);

    List<Reklama> findByKreator(Agent kreator);

    List<Reklama> findByTagovi(Tagovi tag);
}
