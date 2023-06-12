package com.example.Material.query.repositories;

import com.example.Material.query.entities.AssignedMaterial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ListOfAssignedMaterial extends JpaRepository<AssignedMaterial, String> {
    List<AssignedMaterial> findByCollaboratorContaining(String collaborator);

}
