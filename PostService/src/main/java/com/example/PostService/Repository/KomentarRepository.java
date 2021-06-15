package com.example.PostService.Repository;

import com.example.PostService.Model.Komentar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface KomentarRepository extends JpaRepository<Komentar,Integer> {
   List<Komentar> findAll();
}
