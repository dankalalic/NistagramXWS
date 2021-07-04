package com.example.AgentApp.repository;

import com.example.AgentApp.model.Kampanja;
import com.example.AgentApp.model.Korpa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KorpaRepository extends JpaRepository<Korpa,Integer> {
}
