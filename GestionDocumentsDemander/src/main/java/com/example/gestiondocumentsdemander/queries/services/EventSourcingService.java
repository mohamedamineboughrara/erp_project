package com.example.gestiondocumentsdemander.queries.services;

import org.axonframework.eventsourcing.eventstore.DomainEventStream;


public interface EventSourcingService {
    DomainEventStream eventsByDocId(String docId);
}
