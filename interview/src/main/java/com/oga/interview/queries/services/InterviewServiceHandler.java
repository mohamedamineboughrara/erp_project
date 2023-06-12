package com.oga.interview.queries.services;

import com.oga.interview.events.InterviewCreatedEvent;
import com.oga.interview.queries.controllers.GetInterviewQuery;
import com.oga.interview.queries.entities.Interview;
import com.oga.interview.queries.repositories.InterviewRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class InterviewServiceHandler {
    private InterviewRepository interviewRepository;

    @EventHandler
    public void on(InterviewCreatedEvent interviewCreatedEvent){
        log.info("*****");
        log.info("interviewCreatedEventReceived");
        Interview interview = new Interview();
        interview.setInterviewId(interviewCreatedEvent.getId());
        interview.setHumanResourcesManagerId(interviewCreatedEvent.getHumanResourcesManagerId());
        interview.setCandidateId(interviewCreatedEvent.getCandidateId());
        interview.setCivility(interviewCreatedEvent.getCivility());
        interview.setCandidateName(interviewCreatedEvent.getCandidateName());
        interview.setCountry(interviewCreatedEvent.getCountry());
        interview.setCity(interviewCreatedEvent.getCity());
        interview.setEmailAddress(interviewCreatedEvent.getEmailAddress());
        interview.setPhoneNumber(interviewCreatedEvent.getPhoneNumber());
        interview.setDesiredPosition(interviewCreatedEvent.getDesiredPosition());
        interview.setStatus(interviewCreatedEvent.getStatus());
        interviewRepository.save(interview);
    }
    @QueryHandler
    public List<Interview> on(GetInterviewQuery query){return interviewRepository.findAll();}
}
