package com.oga.interview.commands.services;

import com.oga.interview.commands.commands.CreateInterviewCommand;
import com.oga.interview.commands.commands.UpdateInterviewCommand;
import com.oga.interview.commands.dtos.InterviewRequestDTO;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class InterviewCommandServiceImpl implements InterviewCommandService{
    @Autowired
    private CommandGateway commandGateway;
    @Override
    public CompletableFuture<String> createInterview(InterviewRequestDTO interviewRequestDTO) {
        return commandGateway.send(new CreateInterviewCommand(UUID.randomUUID().toString(),interviewRequestDTO.getHumanResourcesManagerId(),interviewRequestDTO.getCandidateId(),interviewRequestDTO.getCivility(),
        interviewRequestDTO.getCandidateName(),interviewRequestDTO.getCountry(),interviewRequestDTO.getCity(),interviewRequestDTO.getEmailAddress(),interviewRequestDTO.getPhoneNumber(),interviewRequestDTO.getDesiredPosition()));
    }
    @Override
    public CompletableFuture<String> updateInterview(InterviewRequestDTO interviewRequestDTO){
        CompletableFuture<String> commandResponse = commandGateway.send(new UpdateInterviewCommand(
                interviewRequestDTO.getInterviewId(),
                interviewRequestDTO.getHumanResourcesManagerId(),
                interviewRequestDTO.getCandidateId(),
                interviewRequestDTO.getCivility(),
                interviewRequestDTO.getCandidateName(),
                interviewRequestDTO.getCountry(),
                interviewRequestDTO.getCity(),
                interviewRequestDTO.getEmailAddress(),
                interviewRequestDTO.getPhoneNumber(),
                interviewRequestDTO.getDesiredPosition()
        ));
        return commandResponse.exceptionally(ex -> {
            throw new RuntimeException("Failed to update Interview" +ex.getMessage());
        });
    }
}
