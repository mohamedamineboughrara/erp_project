package com.oga.interview.commands.controllers;

import com.oga.interview.commands.dtos.InterviewRequestDTO;
import com.oga.interview.commands.services.InterviewCommandService;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping(path = "/commands")
public class InterviewCommandController {
    private final InterviewCommandService interviewCommandService;
    private EventStore eventStore;
    public InterviewCommandController(InterviewCommandService interviewCommandService, EventStore eventStore){
        this.interviewCommandService = interviewCommandService;
        this.eventStore = eventStore;
    }
    @PostMapping(path="/interviews/create")
    public CompletableFuture<String> createInterview(@RequestBody InterviewRequestDTO interviewRequestDTO){
        return interviewCommandService.createInterview(interviewRequestDTO);
    }
    @PutMapping(path = "/update")
    public CompletableFuture<String> updateInterview(@RequestBody InterviewRequestDTO interviewRequestDTO){
        return interviewCommandService.updateInterview(interviewRequestDTO);
    }
    @GetMapping("/eventStore/{interviewId}")
    public Stream eventStore(@PathVariable String interviewId) {
        return (Stream) eventStore.readEvents(interviewId).asStream();
    }


}
