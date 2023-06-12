package com.example.gestiondocumentsdemander.events;

import com.example.gestiondocumentsdemander.enums.DocStatus;
import lombok.Getter;

import java.time.LocalDate;

public class DocStartedEvent extends BaseEvent <String> {
   @Getter private final DocStatus status;

    public DocStartedEvent(String id, DocStatus status) {
        super(id);
        this.status = status;
    }
}
