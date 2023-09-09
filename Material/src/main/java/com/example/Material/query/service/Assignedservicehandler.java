package com.example.Material.query.service;

import com.example.Material.commanApi.event.MaterialAssingedEvent;
import com.example.Material.query.entities.AssignedMaterial;
import com.example.Material.query.entities.Material;
import com.example.Material.query.repositories.ListOfAssignedMaterial;
import com.example.Material.query.repositories.MaterialRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class Assignedservicehandler {
    private MaterialRepository materialRepository;
    private ListOfAssignedMaterial listOfAssignedMaterialrepository;


    @EventHandler
    public void on(MaterialAssingedEvent event) {
        log.info("**********************");
        log.info("MaterialAssignedEvent received");
        log.info("Event ID: " + event.getId());
        log.info("Event ID: " + event.getMaterialId());

        Material material = materialRepository.findById(event.getMaterialId()).orElse(null);
        if (material != null) {
            AssignedMaterial assignedMaterial = new AssignedMaterial();

            assignedMaterial.setId(event.getId());
            assignedMaterial.setMaterialName(event.getMaterialName());
            assignedMaterial.setQuantity(event.getQuantity());
            assignedMaterial.setCollaborator(event.getCollaborator());
            material.setQuantity(material.getQuantity() - event.getQuantity());
            materialRepository.save(material);
            listOfAssignedMaterialrepository.save(assignedMaterial);
        } else {
            throw new RuntimeException("Material not found with id: " + event.getMaterialId());
        }
    }

    @QueryHandler
    public List<AssignedMaterial> on(GetAllAssigned query){
        return listOfAssignedMaterialrepository.findAll();
    }

    @QueryHandler
    public List<AssignedMaterial> on(GetAllAssignedForCollab query){
        return listOfAssignedMaterialrepository.findByCollaboratorContaining(query.getCollaborator());
    }
}
