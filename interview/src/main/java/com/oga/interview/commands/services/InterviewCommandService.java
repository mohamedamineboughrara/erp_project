package com.oga.interview.commands.services;

import com.oga.interview.commands.dtos.InterviewRequestDTO;

import java.util.concurrent.CompletableFuture;

public interface InterviewCommandService {
    CompletableFuture<String> createInterview(InterviewRequestDTO interviewRequestDTO);
    CompletableFuture<String> updateInterview(InterviewRequestDTO interviewRequestDTO);
}
