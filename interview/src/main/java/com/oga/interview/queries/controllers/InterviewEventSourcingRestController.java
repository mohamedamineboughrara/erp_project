package com.oga.interview.queries.controllers;

import com.oga.interview.queries.services.EventSourcingService;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping(path = "/eventSourcing")
public class InterviewEventSourcingRestController {
    private final EventSourcingService interviewQueryService;
    public InterviewEventSourcingRestController(EventSourcingService interviewQueryService){
        this.interviewQueryService = interviewQueryService;
    }
    @GetMapping(path = "/interviewEvents/{id}")
    public Stream eventsByInterviewId(@PathVariable String id){
        return interviewQueryService.eventsByInterviewId(id).asStream();
    }
}
