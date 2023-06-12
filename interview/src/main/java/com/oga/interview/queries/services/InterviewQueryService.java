package com.oga.interview.queries.services;

import com.oga.interview.events.InterviewCreatedEvent;
import com.oga.interview.mappers.InterviewMapper;
import com.oga.interview.queries.controllers.GetInterviewQuery;
import com.oga.interview.queries.dtos.GetAllInterviewsRequestDTO;
import com.oga.interview.queries.dtos.InterviewResponseDTO;
import com.oga.interview.queries.entities.Interview;
import com.oga.interview.queries.repositories.InterviewRepository;
import jakarta.transaction.Transactional;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InterviewQueryService {
    private final InterviewRepository interviewRepository;
    private final InterviewMapper interviewMapper;
    private final QueryUpdateEmitter queryUpdateEmitter;

    public InterviewQueryService(InterviewRepository interviewRepository, InterviewMapper interviewMapper, QueryUpdateEmitter queryUpdateEmitter) {
        this.interviewRepository = interviewRepository;
        this.interviewMapper = interviewMapper;
        this.queryUpdateEmitter = queryUpdateEmitter;
    }
    @EventHandler
    @Transactional
    public void on(InterviewCreatedEvent interviewCreatedEvent){
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

    @QueryHandler
    public List<InterviewResponseDTO>on(GetAllInterviewsRequestDTO interviewsRequestDTO){
        List<Interview> interviewList = interviewRepository.findAll();
        return interviewList.stream().map((app -> interviewMapper.interviewToInterviewDTO(app))).collect(Collectors.toList());
    }

}
