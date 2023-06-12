package com.example.gestiondocumentsdemander.commands.controllers;

import com.example.gestiondocumentsdemander.commands.dtos.DocRequestDTO;
import com.example.gestiondocumentsdemander.commands.exceptions.FalseDateException;
import com.example.gestiondocumentsdemander.commands.services.DocCommandService;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping(path="/commands/Documents")
public class DocCommandContoller {
    private DocCommandService docCommandService;
    private EventStore eventStore;

    public DocCommandContoller(DocCommandService docCommandService, EventStore eventStore) {
        this.docCommandService = docCommandService;
        this.eventStore = eventStore;
    }

    @PostMapping(path = "/create")
    public CompletableFuture<String> createDoc(@RequestBody DocRequestDTO docRequestDTO){
        return docCommandService.createDoc(docRequestDTO);
    }
    @PutMapping(path = "/update")
    public CompletableFuture<String> UpdateDoc(@RequestBody DocRequestDTO docRequestDTO){
        return docCommandService.updateDoc(docRequestDTO);
    }
    @PutMapping(path = "/upload")
    public CompletableFuture<String> uploadDoc(@RequestBody DocRequestDTO docRequestDTO){
        return docCommandService.uploadedDoc(docRequestDTO);
    }
    @GetMapping("/eventStore/{docId}")
    public Stream eventStore(@PathVariable String docId){
        return (Stream)eventStore.readEvents(docId).asStream() ;
    }

    @ExceptionHandler(FalseDateException.class)
    public ResponseEntity<String> exceptionHandler(FalseDateException exception){
        return new ResponseEntity<String>(exception.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
