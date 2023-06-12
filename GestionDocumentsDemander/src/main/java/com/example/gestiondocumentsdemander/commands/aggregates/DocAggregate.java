package com.example.gestiondocumentsdemander.commands.aggregates;


import com.example.gestiondocumentsdemander.commands.commonapi.CreateDocCommand;
import com.example.gestiondocumentsdemander.commands.commonapi.UpdateDocCommand;
import com.example.gestiondocumentsdemander.commands.commonapi.UploadedDocCommand;
import com.example.gestiondocumentsdemander.enums.DocStatus;
import com.example.gestiondocumentsdemander.events.DocCreatedEvent;
import com.example.gestiondocumentsdemander.events.DocUpdatedEvent;
import com.example.gestiondocumentsdemander.events.DocUploadEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import lombok.extern.slf4j.Slf4j;
import java.time.LocalDate;
@Aggregate
@Slf4j
public class DocAggregate {

    @AggregateIdentifier
    private String docId;
    private String firstName;
    private String lastName;
    private String instituteName;
    private String post;
    private LocalDate startDate;
    private LocalDate endDate;
    private String typeDoc;
    private DocStatus status;
    private String adress;
    private String contractType;
    private String salary;
    private String supervisorName;
    private String workingHours;
    private String month;
    private String year;
    private String details;
    private String filePath;

    public DocAggregate() {
}

    @CommandHandler
    public DocAggregate(CreateDocCommand createDocCommand) {

        log.info("CreateDocCommand Reveived");
        AggregateLifecycle.apply(
                new DocCreatedEvent(
                        createDocCommand.getId(),
                        createDocCommand.getFirstName(),
                        createDocCommand.getLastName(),
                        createDocCommand.getInstituteName(),
                        createDocCommand.getPost(),
                        createDocCommand.getStartDate(),
                        createDocCommand.getEndDate(),
                        createDocCommand.getTypeDoc(),
                        DocStatus.ON_HOLD,
                        createDocCommand.getFilePath(),
                        createDocCommand.getAdress(),
                        createDocCommand.getContractType(),
                        createDocCommand.getSalary(),
                        createDocCommand.getSupervisorName(),
                        createDocCommand.getWorkingHours(),
                        createDocCommand.getMonth(),
                        createDocCommand.getYear(),
                        createDocCommand.getDetails()
                ));

    }
        @EventSourcingHandler
        public void on(DocCreatedEvent event){
            log.info("DocCreatedEvent Occured");
            this.docId= event.getId();
            this.firstName=event.getFirstName();
            this.lastName=event.getLastName();
            this.instituteName= event.getInstituteName();
            this.post =event.getPost();
            this.startDate= event.getStartDate();
            this.endDate= event.getEndDate();
            this.typeDoc=event.getTypeDoc();
            this.status=event.getStatus();
            this.filePath=event.getFilePath();
            this.adress= event.getAdress();
            this.contractType= event.getContractType();
            this.salary= event.getSalary();
            this.supervisorName=event.getSupervisorName();
            this.workingHours= event.getWorkingHours();
            this.month=event.getMonth();
            this.year=event.getYear();
            this.details=event.getDetails();
        }
        @CommandHandler
        public void DocAggregate(UpdateDocCommand command){

        AggregateLifecycle.apply(new DocUpdatedEvent(
               command.getDocId(),
                command.getFirstName(),
                command.getLastName(),
                command.getInstituteName(),
                command.getPost(),
                command.getStartDate(),
                command.getEndDate(),
                command.getTypeDoc(),
                DocStatus.UPDATED,
                command.getFilePath(),
                command.getAdress(),
                command.getContractType(),
                command.getSalary(),
                command.getSupervisorName(),
                command.getWorkingHours(),
                command.getMonth(),
                command.getYear(),
                command.getDetails()
        ));
        }
    @EventSourcingHandler
    public void on(DocUpdatedEvent event){
        this.docId= event.getId();
        this.firstName= event.getFirstName();
        this.lastName= event.getLastName();
        this.instituteName=event.getInstituteName();
        this.post=event.getPost();
        this.startDate= event.getStartDate();
        this.endDate=event.getEndDate();
        this.typeDoc=event.getTypeDoc();
        this.status=event.getStatus();
        this.filePath=event.getFilePath();
        this.adress= event.getAdress();
        this.contractType= event.getContractType();
        this.salary= event.getSalary();
        this.supervisorName=event.getSupervisorName();
        this.workingHours= event.getWorkingHours();
        this.month=event.getMonth();
        this.year=event.getYear();
        this.details=event.getDetails();
    }
    @CommandHandler
    public void DocAggregate(UploadedDocCommand command){

        AggregateLifecycle.apply(new DocUpdatedEvent(
                command.getDocId(),
                command.getFirstName(),
                command.getLastName(),
                command.getInstituteName(),
                command.getPost(),
                command.getStartDate(),
                command.getEndDate(),
                command.getTypeDoc(),
                DocStatus.UPLOADED,
                command.getFilePath(),
                command.getAdress(),
                command.getContractType(),
                command.getSalary(),
                command.getSupervisorName(),
                command.getWorkingHours(),
                command.getMonth(),
                command.getYear(),
                command.getDetails()
        ));
    }
    @EventSourcingHandler
    public void on(DocUploadEvent event){
        this.docId= event.getId();
        this.firstName= event.getFirstName();
        this.lastName= event.getLastName();
        this.instituteName=event.getInstituteName();
        this.post=event.getPost();
        this.startDate= event.getStartDate();
        this.endDate=event.getEndDate();
        this.typeDoc=event.getTypeDoc();
        this.status=event.getStatus();
        this.filePath=event.getFilePath();
        this.adress= event.getAdress();
        this.contractType= event.getContractType();
        this.salary= event.getSalary();
        this.supervisorName=event.getSupervisorName();
        this.workingHours= event.getWorkingHours();
        this.month=event.getMonth();
        this.year=event.getYear();
        this.details=event.getDetails();
    }


}
