package com.example.gfichpaie.queries.repositories;

import com.example.gfichpaie.queries.entities.FDP;

import org.springframework.data.jpa.repository.JpaRepository;


public interface FDPRepository extends JpaRepository<FDP,String> {
    FDP findByUserName(String userName);
}
