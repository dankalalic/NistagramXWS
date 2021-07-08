package com.example.messagesservice.repository;

import com.example.messagesservice.model.Poruka;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PorukaRepository extends JpaRepository<Poruka, Integer> {

}
