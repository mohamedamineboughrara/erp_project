package com.oga.interview.queries.services;

import org.axonframework.eventsourcing.eventstore.DomainEventStream;

public interface EventSourcingService {
    DomainEventStream eventsByInterviewId(String interviewId);
}
