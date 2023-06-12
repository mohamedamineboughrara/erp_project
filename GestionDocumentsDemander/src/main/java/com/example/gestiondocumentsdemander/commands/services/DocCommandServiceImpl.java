package com.example.gestiondocumentsdemander.commands.services;

import com.example.gestiondocumentsdemander.commands.commonapi.CreateDocCommand;
import com.example.gestiondocumentsdemander.commands.commonapi.UpdateDocCommand;
import com.example.gestiondocumentsdemander.commands.commonapi.UploadedDocCommand;
import com.example.gestiondocumentsdemander.commands.dtos.DocRequestDTO;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class DocCommandServiceImpl implements DocCommandService {
@Autowired
    private CommandGateway commandGateway;
    private CreateDocCommand command;
    @Override
    public CompletableFuture<String> createDoc(DocRequestDTO docRequestDTO) {
            return commandGateway.send(new CreateDocCommand(
                    UUID.randomUUID().toString(),
                    docRequestDTO.getFirstName(),
                    docRequestDTO.getLastName(),
                    docRequestDTO.getInstituteName(),
                    docRequestDTO.getPost(),
                    docRequestDTO.getStartDate(),
                    docRequestDTO.getEndDate(),
                    docRequestDTO.getTypeDoc(),
                    docRequestDTO.getFilePath(),
                    docRequestDTO.getAdress(),
                    docRequestDTO.getContractType(),
                    docRequestDTO.getSalary(),
                    docRequestDTO.getSupervisorName(),
                    docRequestDTO.getWorkingHours(),
                    docRequestDTO.getMonth(),
                    docRequestDTO.getYear(),
                    docRequestDTO.getDetails()
            ));
        }

@Override
    public CompletableFuture<String> updateDoc(DocRequestDTO docRequestDTO) {
        CompletableFuture<String> commandResponse = commandGateway.send(new UpdateDocCommand(
                docRequestDTO.getDocId(),
                docRequestDTO.getFirstName(),
                docRequestDTO.getLastName(),
                docRequestDTO.getInstituteName(),
                docRequestDTO.getPost(),
                docRequestDTO.getStartDate(),
                docRequestDTO.getEndDate(),
                docRequestDTO.getTypeDoc(),
                docRequestDTO.getFilePath(),
                docRequestDTO.getAdress(),
                docRequestDTO.getContractType(),
                docRequestDTO.getSalary(),
                docRequestDTO.getSupervisorName(),
                docRequestDTO.getWorkingHours(),
                docRequestDTO.getMonth(),
                docRequestDTO.getYear(),
                docRequestDTO.getDetails()
    ));
        return commandResponse.exceptionally(ex -> {
            throw new RuntimeException("Failed to update CRAs: " + ex.getMessage());
        });

    }
    @Override
    public CompletableFuture<String> uploadedDoc(DocRequestDTO docRequestDTO) {
        CompletableFuture<String> commandResponse = commandGateway.send(new UploadedDocCommand(
                docRequestDTO.getDocId(),
                docRequestDTO.getFirstName(),
                docRequestDTO.getLastName(),
                docRequestDTO.getInstituteName(),
                docRequestDTO.getPost(),
                docRequestDTO.getStartDate(),
                docRequestDTO.getEndDate(),
                docRequestDTO.getTypeDoc(),
                docRequestDTO.getFilePath(),
                docRequestDTO.getAdress(),
                docRequestDTO.getContractType(),
                docRequestDTO.getSalary(),
                docRequestDTO.getSupervisorName(),
                docRequestDTO.getWorkingHours(),
                docRequestDTO.getMonth(),
                docRequestDTO.getYear(),
                docRequestDTO.getDetails()
        ));
        return commandResponse.exceptionally(ex -> {
            throw new RuntimeException("Failed to update Document: " + ex.getMessage());
        });

    }
}
