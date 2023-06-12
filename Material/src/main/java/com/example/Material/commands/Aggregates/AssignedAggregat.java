package com.example.Material.commands.Aggregates;

import com.example.Material.commanApi.commands.AssignMaterialCommand;
import com.example.Material.commanApi.event.MaterialAssingedEvent;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
@Slf4j
public class AssignedAggregat {
    @AggregateIdentifier
    private String id;
    private String materialName;
    private int quantity;
    private String collaborator;
    private String materialId;


    public AssignedAggregat() {
    }

    @CommandHandler
    public AssignedAggregat(AssignMaterialCommand command) {
        AggregateLifecycle.apply(new MaterialAssingedEvent(
                command.getId(),
                command.getMaterialId(),
                command.getMaterialName(),
                command.getQuantity(),
                command.getCollaborator()
        ));
    }

    @EventSourcingHandler
    public void on(MaterialAssingedEvent event) {
        this.id = event.getId();
        this.materialId = event.getMaterialId();
        this.materialName = event.getMaterialName();
        this.quantity = event.getQuantity();
        this.collaborator = event.getCollaborator();
    }
}
