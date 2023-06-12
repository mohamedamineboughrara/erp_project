package com.oga.interview.queries.entities;

import com.oga.interview.enums.InterviewStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Interview {
    @Id
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
    @Enumerated(EnumType.STRING)
    private InterviewStatus status;




}
