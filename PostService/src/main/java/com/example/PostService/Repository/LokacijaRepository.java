package com.example.PostService.Repository;

import com.example.PostService.Model.Komentar;
import com.example.PostService.Model.Lokacija;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LokacijaRepository extends JpaRepository<Lokacija,Integer> {
    Lokacija findByNaziv(String naziv);
}
