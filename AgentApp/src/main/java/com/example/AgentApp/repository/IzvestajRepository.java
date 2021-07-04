package com.example.AgentApp.repository;

import com.example.AgentApp.model.Izvestaj;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IzvestajRepository extends JpaRepository<Izvestaj,Integer> {
}
