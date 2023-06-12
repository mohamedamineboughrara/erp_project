package com.example.Material.commands.Controller;

import com.example.Material.commanApi.commands.AssignMaterialCommand;
import com.example.Material.commanApi.commands.DeletMaterialCommand;
import com.example.Material.commanApi.commands.MaterialCommand;
import com.example.Material.commanApi.dtos.AssingMAterialRequestDto;
import com.example.Material.commanApi.dtos.MaterialRequsetDTO;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

@CrossOrigin(origins = "*")

@RestController
@RequestMapping(path="/commands/material")
@AllArgsConstructor
@Slf4j
public class MaterialCommandController {
    private CommandGateway commandGateway;
    private EventStore eventStore;



    @PostMapping(path= "/create")
    public CompletableFuture<String> createMaterial(@RequestBody MaterialRequsetDTO requestDTO){

        return commandGateway.send(new MaterialCommand(
                UUID.randomUUID().toString(),
                requestDTO.getMaterialName(),
                requestDTO.getQuantity(),
                requestDTO.getPhoto()

        ));


    }
    @ExceptionHandler
    public ResponseEntity<String> exeptionHandler(Exception exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @GetMapping("/eventStore/{MaterialId}")
    public Stream eventStore(@PathVariable String ProjectId){
        return (Stream)eventStore.readEvents(ProjectId).asStream() ;

    }
    @PostMapping("/assign")
    public CompletableFuture<String> assignMaterial(@RequestBody AssingMAterialRequestDto request){
        log.info("Assigning material with ID: " + request.getMaterialId());

        return commandGateway.send(new AssignMaterialCommand(
                UUID.randomUUID().toString(),
                request.getMaterialId(),
                request.getMaterialName(),
                request.getQuantity(),
                request.getCollaborator()
        ));
    }
    @DeleteMapping(path = "/delete/{MaterialId}")
    public ResponseEntity<String> RemoveMaterial(@PathVariable String MaterialId) {
        try {
            commandGateway.send(new DeletMaterialCommand(MaterialId));
            return ResponseEntity.ok("Material with id " + MaterialId + " deleted successfully.");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Material with id " + MaterialId + " not found.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete Material with id " + MaterialId + ": " + e.getMessage());
        }
    }

}
