package com.example.Material.query.service;

import com.example.Material.commanApi.event.MaterialAssingedEvent;
import com.example.Material.commanApi.event.MaterialCreatedEvent;
import com.example.Material.commanApi.event.MaterialDeletedEvent;
import com.example.Material.query.entities.AssignedMaterial;
import com.example.Material.query.entities.Material;
import com.example.Material.query.repositories.ListOfAssignedMaterial;
import com.example.Material.query.repositories.MaterialRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class MaterialServiceHandler {
    private MaterialRepository materialRepository;
    private ListOfAssignedMaterial listOfAssignedMaterialrepository;


    @EventHandler
    public void on(MaterialCreatedEvent event){
        log.info("**********************");
        log.info("MaterialCreatedEvent received");
        Material material=new Material();
        material.setId(event.getMaterialId());
        material.setMaterialName(event.getMaterialName());
        material.setQuantity(event.getQuantity());
        material.setPhoto(event.getPhoto());

        materialRepository.save(material);
    }

    @QueryHandler
    public List<Material> on(GetAllMaterial query){
        return materialRepository.findAll();
    }

    @EventHandler
    public void on(MaterialDeletedEvent event) {
        try {
            materialRepository.deleteById(event.getId());
        } catch (EmptyResultDataAccessException ex) {
            throw new EntityNotFoundException("Ad not found with id: " + event.getId());
        }}
}
