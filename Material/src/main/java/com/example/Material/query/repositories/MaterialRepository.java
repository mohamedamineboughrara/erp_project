package com.example.Material.query.repositories;

import com.example.Material.query.entities.Material;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialRepository extends JpaRepository<Material, String> {

}
