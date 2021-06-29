package com.example.PostService.Repository;

import com.example.PostService.Model.Komentar;
import com.example.PostService.Model.Tagovi;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface TagRepository extends JpaRepository<Tagovi,Integer> {
    Tagovi findByNaziv(String naziv);

    Set<Tagovi> findAllByNaziv(String naziv);
}
