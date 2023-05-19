package com.example.Erp.Commands.controllers;

import com.example.Erp.Exception.MissingInputException;
import com.example.Erp.commonApi.commands.ModuleCommand.CreateModuleCommand;
import com.example.Erp.commonApi.commands.ModuleCommand.UpdateModuleCommand;
import com.example.Erp.commonApi.commands.ProjectCommand.DeletProjectCommand;
import com.example.Erp.commonApi.dtos.ModuleRequestDTO;
import lombok.AllArgsConstructor;
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
@RequestMapping(path="/commands/module")
@AllArgsConstructor
public class ModuleCommandController {
    private CommandGateway commandGateway;
    private EventStore eventStore;
    @PostMapping(path= "/create")
    public CompletableFuture<String> createModule(@RequestBody ModuleRequestDTO requestDTO){
        return commandGateway.send(new CreateModuleCommand(
                UUID.randomUUID().toString(),
                requestDTO.getModuleTitle(),
                requestDTO.getModuleDescription(),
                requestDTO.getUserId(),
                requestDTO.getProject()
        ));
    }




    @ExceptionHandler
    public ResponseEntity<String> exeptionHandler(Exception exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/eventStore/{moduleId}")
    public Stream eventStore(@PathVariable String moduleId){
        return (Stream)eventStore.readEvents(moduleId).asStream() ;

    }

    @CrossOrigin(origins = "*")
    @PutMapping(path = "/update")
    public CompletableFuture<String> updateModule( @RequestBody ModuleRequestDTO requestDTO)
    { CompletableFuture<String> commandResponse = commandGateway.send(new UpdateModuleCommand(
            requestDTO.getModuleId(),
            requestDTO.getModuleTitle(),
            requestDTO.getModuleDescription(),
            requestDTO.getUserId(),
            requestDTO.getProject()
    ));
        return commandResponse.exceptionally(ex -> {
            throw new MissingInputException("Failed to update PROJECT: " + ex.getMessage());
        });

    }

    @DeleteMapping(path = "/{moduleId}")
    public CompletableFuture<String> deleteProject(@PathVariable String moduleId){
        return commandGateway.send((new DeletProjectCommand(moduleId)));
    }
}
