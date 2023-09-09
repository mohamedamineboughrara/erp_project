package org.oga.gestioncras.commands.aggregates;


import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.oga.gestioncras.commands.commonapi.*;
import org.oga.gestioncras.enums.CRAsStatus;
import org.oga.gestioncras.events.*;
import lombok.extern.slf4j.Slf4j;
import org.oga.gestioncras.exceptions.NullInputException;

import java.time.LocalDate;

@Aggregate
@Slf4j
public class CRAsAggregate {


    @AggregateIdentifier
    private String crasId;
    private String timeSpent;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private String idProject;
    private String idResponsible;
    private String idCollaborator;
    private String comment;
    private double productivity;
    private Boolean approve;
    private CRAsStatus status;

public CRAsAggregate() {

}

    @CommandHandler
    public CRAsAggregate(CreateCRAsCommand createCRAsCommand) {
        if((createCRAsCommand.getDescription()==null) || (createCRAsCommand.getStartDate()==null) || (createCRAsCommand.getEndDate()==null) || (createCRAsCommand.getIdProject()==null)){
            throw new NullInputException("Input should not be null");
        }
        if (createCRAsCommand.getEndDate().isBefore(createCRAsCommand.getStartDate())) {
            throw new IllegalArgumentException("The end date cannot be earlier than the start date");
        }
        log.info("CreateCRAsCommand Reveived");



        AggregateLifecycle.apply(
                new CRAsCreatedEvent(
                       createCRAsCommand.getId(),
                        createCRAsCommand.getTimeSpent(),
                        createCRAsCommand.getDescription(),
                        createCRAsCommand.getStartDate(),
                        createCRAsCommand.getEndDate(),
                        createCRAsCommand.getIdProject(),
                        createCRAsCommand.getIdResponsible(),
                        createCRAsCommand.getIdCollaborator(),
                        createCRAsCommand.getComment(),
                        createCRAsCommand.getProductivity(),

                        CRAsStatus.CREATED));

    }
        @EventSourcingHandler
        public void on(CRAsCreatedEvent event){
            log.info("CRAsCreatedEvent Occured");
            this.crasId= event.getId();
            this.startDate=event.getStartDate();
            this.endDate=event.getEndDate();
            this.description= event.getDescription();
            this.timeSpent =event.getTimeSpent();
            this.idProject= event.getIdProject();
            this.idCollaborator= event.getIdCollaborator();
            this.idResponsible= event.getIdResponsible();
            this.comment= event.getComment();
            this.productivity=event.getProductivity();
            this.status=event.getStatus();
        }
        @CommandHandler
        public CRAsAggregate(UpdateCRAsCommand command){
            if((command.getDescription()==null) || (command.getStartDate()==null) || (command.getEndDate()==null)  || (command.getIdProject()==null)){
                throw new NullInputException("Input should not be null");
            }
            if (command.getEndDate().isBefore(command.getStartDate())) {
                throw new IllegalArgumentException("The end date cannot be earlier than the start date");
            }
        AggregateLifecycle.apply(new CRAsUpdatedEvent(
               command.getCrasId(),
                command.getTimeSpent(),
                command.getDescription(),
                command.getStartDate(),
                command.getEndDate(),
                command.getIdProject(),
                command.getIdResponsible(),
                command.getIdCollaborator(),
                command.getComment(),
                command.getProductivity(),

                CRAsStatus.UPDATED
        ));
        }
    @EventSourcingHandler
    public void on(CRAsUpdatedEvent event){
        this.crasId= event.getId();
        this.timeSpent= event.getTimeSpent();
        this.description= event.getDescription();
        this.startDate=event.getStartDate();
        this.endDate=event.getEndDate();
        this.idProject= event.getIdProject();
        this.idResponsible=event.getIdResponsible();
        this.idCollaborator= event.getIdCollaborator();
        this.comment= event.getComment();
        this.productivity=event.getProductivity();

        this.status=event.getStatus();
    }
    @CommandHandler
    public void deleteCRAs(DeleteCRAsCommand command) {
        AggregateLifecycle.apply(new CRAsDeletedEvent(command.getId()));
    }
    @EventSourcingHandler
    public void on(CRAsDeletedEvent event) {
        AggregateLifecycle.markDeleted();
    }


    @CommandHandler
    public void on(ConfirmedCRAsCommand command){
        AggregateLifecycle.apply(new CRAsUpdatedEvent(
                command.getId(),
                command.getTimeSpent(),
                command.getDescription(),
                command.getStartDate(),
                command.getEndDate(),
                command.getIdProject(),
                command.getIdResponsible(),
                command.getIdCollaborator(),
                command.getComment(),
                command.getProductivity(),
                CRAsStatus.CONFIRMED
        ));
    }
    @EventSourcingHandler
    public void on(CRAsConfirmedEvent event){
        this.crasId= event.getId();
        this.timeSpent= event.getTimeSpent();
        this.description= event.getDescription();
        this.startDate=event.getStartDate();
        this.endDate=event.getEndDate();
        this.idProject= event.getIdProject();
        this.idResponsible=event.getIdResponsible();
        this.idCollaborator= event.getIdCollaborator();
        this.comment= event.getComment();
        this.productivity=event.getProductivity();
        this.status=event.getStatus();
    }
    @CommandHandler
    public void on(RejectedCRAsCommand command){
        AggregateLifecycle.apply(new CRAsUpdatedEvent(
                command.getId(),
                command.getTimeSpent(),
                command.getDescription(),
                command.getStartDate(),
                command.getEndDate(),
                command.getIdProject(),
                command.getIdResponsible(),
                command.getIdCollaborator(),
                command.getComment(),
                command.getProductivity(),
                CRAsStatus.REJECTED
        ));
    }
    @EventSourcingHandler
    public void on(CRAsRejectedEvent event){
        this.crasId= event.getId();
        this.timeSpent= event.getTimeSpent();
        this.description= event.getDescription();
        this.startDate=event.getStartDate();
        this.endDate=event.getEndDate();
        this.idProject= event.getIdProject();
        this.idResponsible=event.getIdResponsible();
        this.idCollaborator= event.getIdCollaborator();
        this.comment= event.getComment();
        this.productivity=event.getProductivity();
        this.status=event.getStatus();
    }
}


