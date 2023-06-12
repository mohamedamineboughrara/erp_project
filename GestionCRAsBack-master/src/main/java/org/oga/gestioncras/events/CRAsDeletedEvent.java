package org.oga.gestioncras.events;

public class CRAsDeletedEvent extends BaseEvent<String> {

    public CRAsDeletedEvent(String id) {
        super(id);
    }
}
