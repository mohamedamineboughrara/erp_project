package com.oga.interview.events;

import com.oga.interview.enums.InterviewStatus;
import lombok.Getter;


public class InterviewUpdatedEvent extends BaseEvent<String>{
    @Getter private String humanResourcesManagerId;
    @Getter private String candidateId;
    @Getter private String civility;
    @Getter private String candidateName;
    @Getter private String country;
    @Getter private String city;
    @Getter private String emailAddress;
    @Getter private long phoneNumber;
    @Getter private String desiredPosition;
    @Getter private InterviewStatus status;

    public InterviewUpdatedEvent(String id, String humanResourcesManagerId, String candidateId,String civility, String candidateName,String country,String city, String emailAddress, long phoneNumber, String desiredPosition, InterviewStatus status) {
        super(id);
        this.humanResourcesManagerId = humanResourcesManagerId;
        this.candidateId = candidateId;
        this.civility = civility;
        this.candidateName = candidateName;
        this.country = country;
        this.city = city;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.desiredPosition = desiredPosition;
        this.status = status;
    }
}
