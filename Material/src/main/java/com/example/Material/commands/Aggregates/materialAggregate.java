package com.example.Material.commands.Aggregates;

import com.example.Material.commanApi.commands.AssignMaterialCommand;
import com.example.Material.commanApi.commands.DeletMaterialCommand;
import com.example.Material.commanApi.commands.MaterialCommand;
import com.example.Material.commanApi.enums.materialStatus;
import com.example.Material.commanApi.event.MaterialAssingedEvent;
import com.example.Material.commanApi.event.MaterialCreatedEvent;
import com.example.Material.commanApi.event.MaterialDeletedEvent;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
@Slf4j
public class materialAggregate {
    @AggregateIdentifier
    private String materialId;
    private String materialName;
    private int quantity;
    private materialStatus status;
    public materialAggregate() {
    }
    @CommandHandler
    public materialAggregate(MaterialCommand command){
        AggregateLifecycle.apply((new MaterialCreatedEvent(
                command.getMaterialId(),
                command.getMaterialName(),
                command.getQuantity(),
                command.getPhoto(),
                materialStatus.CREATED)));
    }
    @EventSourcingHandler
    public void on(MaterialCreatedEvent event) {
       this.materialId = event.getMaterialId();
       this.materialName = event.getMaterialName();
       this.quantity = event.getQuantity();
        this.status=event.getStatus();


    }
    @CommandHandler
    public void handle(DeletMaterialCommand command) {
        if (this.status == materialStatus.DELETED) {
            throw new IllegalStateException("Material is already deleted");
        }
        AggregateLifecycle.apply(new MaterialDeletedEvent(command.getId()));
    }
    @EventSourcingHandler
    public void on(MaterialDeletedEvent event) {

        AggregateLifecycle.markDeleted();
    }

}
