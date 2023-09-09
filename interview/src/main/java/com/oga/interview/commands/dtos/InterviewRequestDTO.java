package com.oga.interview.commands.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class InterviewRequestDTO {
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

}
