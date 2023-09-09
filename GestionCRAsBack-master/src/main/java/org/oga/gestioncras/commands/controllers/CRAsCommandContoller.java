package org.oga.gestioncras.commands.controllers;

import org.axonframework.eventsourcing.eventstore.EventStore;
import org.oga.gestioncras.commands.dtos.CRAsRequestDTO;
import org.oga.gestioncras.commands.exceptions.FalseDateException;
import org.oga.gestioncras.commands.services.CRAsCommandService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping(path="/commands/CRAs")
public class CRAsCommandContoller {
    private final CRAsCommandService crAsCommandService;
    private final EventStore eventStore;

    public CRAsCommandContoller(CRAsCommandService crAsCommandService, EventStore eventStore) {
        this.crAsCommandService = crAsCommandService;
        this.eventStore = eventStore;
    }

    @PostMapping(path = "/create")
    public CompletableFuture<String> createCRAs(@RequestBody CRAsRequestDTO crAsRequestDTO){
        return crAsCommandService.createCRAs(crAsRequestDTO);
    }
    @PutMapping(path = "/update")
    public CompletableFuture<String> updateCRAs(@RequestBody CRAsRequestDTO request){
        return crAsCommandService.updateCRAs(request);
    }
    @DeleteMapping(path = "/delete/{craId}")
    public CompletableFuture<String> deleteCRAs(@PathVariable String craId) {
        return crAsCommandService.deleteCRAs(craId);
    }

    @GetMapping("/eventStore/{crasId}")
    public Stream eventStore(@PathVariable String crasId){
        return (Stream)eventStore.readEvents(crasId).asStream() ;
    }


    @PutMapping(path = "/confirm")
    public CompletableFuture<String> confirmCRAs(@RequestBody CRAsRequestDTO crAsRequestDTO) {
        return crAsCommandService.confirmCRAs(crAsRequestDTO);
    }
    @PutMapping(path ="/rejected")
    public CompletableFuture<String> rejectedCRAs(@RequestBody CRAsRequestDTO crAsRequestDTO) {
        return crAsCommandService.rejectedCRAs(crAsRequestDTO);
    }
    @ExceptionHandler(FalseDateException.class)
    public ResponseEntity<String> exceptionHandler(FalseDateException exception){
        return new ResponseEntity<String>(exception.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
