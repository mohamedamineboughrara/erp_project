package com.oga.interview.commands.aggregates;

import com.oga.interview.commands.commands.CreateInterviewCommand;
import com.oga.interview.commands.commands.UpdateInterviewCommand;
import com.oga.interview.enums.InterviewStatus;
import com.oga.interview.events.InterviewCreatedEvent;
import com.oga.interview.events.InterviewUpdatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;


@Aggregate
@Slf4j
public class InterviewAggregate {
    @AggregateIdentifier
    private String interviewId;
    private String humanResourcesManagerId;
    private String candidateId;
    private String civility;
    private String candidateName;
    private String country;
    private String city;
    private String emailAddress;
    private long phoneNumber;
    private String desiredPosition;
    private String status;
    public InterviewAggregate(){
        // Required by AXON
    }
    @CommandHandler
    public InterviewAggregate(CreateInterviewCommand createInterviewCommand) {
        log.info("CreatedInterview Received");
        AggregateLifecycle.apply(new InterviewCreatedEvent(
                createInterviewCommand.getId(),
                createInterviewCommand.getHumanResourcesManagerId(),
                createInterviewCommand.getCandidateId(),
                createInterviewCommand.getCivility(),
                createInterviewCommand.getCandidateName(),
                createInterviewCommand.getCountry(),
                createInterviewCommand.getCity(),
                createInterviewCommand.getEmailAddress(),
                createInterviewCommand.getPhoneNumber(),
                createInterviewCommand.getDesiredPosition(),
                InterviewStatus.CREATED
        ));
    }
    @EventSourcingHandler
    public  void on(InterviewCreatedEvent interviewCreatedEvent){
        log.info("InterviewCreatedEvent Occurred");
        this.interviewId=interviewCreatedEvent.getId();
        this.humanResourcesManagerId=interviewCreatedEvent.getHumanResourcesManagerId();
        this.candidateId=interviewCreatedEvent.getCandidateId();
        this.civility=interviewCreatedEvent.getCivility();
        this.candidateName=interviewCreatedEvent.getCandidateName();
        this.country=interviewCreatedEvent.getCountry();
        this.city=interviewCreatedEvent.getCity();
        this.emailAddress=interviewCreatedEvent.getEmailAddress();
        this.phoneNumber=interviewCreatedEvent.getPhoneNumber();
        this.desiredPosition=interviewCreatedEvent.getDesiredPosition();
        this.status=String.valueOf(interviewCreatedEvent.getStatus());
    }
    @CommandHandler
    public void on(UpdateInterviewCommand updateInterviewCommand) {
        if ((updateInterviewCommand.getCandidateId()==null) || (updateInterviewCommand.getCandidateName()==null) || (updateInterviewCommand.getEmailAddress()==null)){
            throw new RuntimeException("Input should not be null");
        }
        AggregateLifecycle.apply(new InterviewUpdatedEvent(
                updateInterviewCommand.getId(),
                updateInterviewCommand.getHumanResourcesManagerId(),
                updateInterviewCommand.getCandidateId(),
                updateInterviewCommand.getCivility(),
                updateInterviewCommand.getCandidateName(),
                updateInterviewCommand.getCountry(),
                updateInterviewCommand.getCity(),
                updateInterviewCommand.getEmailAddress(),
                updateInterviewCommand.getPhoneNumber(),
                updateInterviewCommand.getDesiredPosition(),
                InterviewStatus.UPDATED
        ));
    }
    @EventSourcingHandler
    public void on(InterviewUpdatedEvent interviewUpdatedEvent){
        log.info("InterviewUpdatedEvent occurred");
        this.interviewId=interviewUpdatedEvent.getId();
        this.humanResourcesManagerId=interviewUpdatedEvent.getHumanResourcesManagerId();
        this.candidateId=interviewUpdatedEvent.getCandidateId();
        this.civility=interviewUpdatedEvent.getCivility();
        this.candidateName=interviewUpdatedEvent.getCandidateName();
        this.country=interviewUpdatedEvent.getCountry();
        this.city=interviewUpdatedEvent.getCity();
        this.emailAddress=interviewUpdatedEvent.getEmailAddress();
        this.phoneNumber=interviewUpdatedEvent.getPhoneNumber();
        this.desiredPosition=interviewUpdatedEvent.getDesiredPosition();
        this.status=String.valueOf(interviewUpdatedEvent.getStatus());
    }
}
