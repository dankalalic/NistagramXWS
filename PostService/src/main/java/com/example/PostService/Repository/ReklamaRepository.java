package com.example.PostService.Repository;

import com.example.PostService.Model.Reklama;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReklamaRepository extends JpaRepository<Reklama, Integer> {

    Reklama findOneById(Integer id);
}
