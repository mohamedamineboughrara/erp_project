package com.example.gestiondocumentsdemander.queries.controllers;

import com.example.gestiondocumentsdemander.queries.services.EventSourcingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.stream.Stream;
@RestController
@RequestMapping(path="/eventSourcing")
public class DocEventSourcingRestController {
    private final EventSourcingService docQueryService;

    public DocEventSourcingRestController(EventSourcingService docQueryService) {
        this.docQueryService = docQueryService;
    }


    @GetMapping(path = "/crasEvents/{id}")
    public Stream eventsByCRAsId(@PathVariable String id){
        return docQueryService.eventsByDocId(id).asStream();
    }
}
