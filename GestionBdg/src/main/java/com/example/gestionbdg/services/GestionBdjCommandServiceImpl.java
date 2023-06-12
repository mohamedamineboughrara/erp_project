package com.example.gestionbdg.services;

import com.example.gestionbdg.commonapi.CreateCjmCommand;
import com.example.gestionbdg.commonapi.UpdateCjmCommand;
import com.example.gestionbdg.dtos.GestionBdgDTO;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class GestionBdjCommandServiceImpl implements GestionBdjCommandService {
@Autowired
    private CommandGateway commandGateway;

    @Override
    public CompletableFuture<String> createGBdj(GestionBdgDTO gestionBdgDTO) {
        return commandGateway.send(new CreateCjmCommand(
                        UUID.randomUUID().toString(),
                gestionBdgDTO.getCollaborator(),
                gestionBdgDTO.getTjm(),
                gestionBdgDTO.getCjm(),
                gestionBdgDTO.getTask(),
                gestionBdgDTO.getDayNumber(),
                gestionBdgDTO.getProject()));
    }
@Override
    public CompletableFuture<String> updateGBdj(GestionBdgDTO gestionBdgDTO)
    { CompletableFuture<String> commandResponse = commandGateway.send(new UpdateCjmCommand(
          gestionBdgDTO.getBdgId(),
            gestionBdgDTO.getCollaborator(),
            gestionBdgDTO.getTjm(),
            gestionBdgDTO.getCjm(),
            gestionBdgDTO.getTask(),
            gestionBdgDTO.getDayNumber(),
            gestionBdgDTO.getProject()));
        return commandResponse.exceptionally(ex -> {
            throw new RuntimeException("Failed to update FdP: " + ex.getMessage());
        });
    }
}
