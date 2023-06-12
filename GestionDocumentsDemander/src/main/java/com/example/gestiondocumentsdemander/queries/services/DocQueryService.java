package com.example.gestiondocumentsdemander.queries.services;

import com.example.gestiondocumentsdemander.events.DocCreatedEvent;
import com.example.gestiondocumentsdemander.events.DocUpdatedEvent;
import com.example.gestiondocumentsdemander.events.DocUploadEvent;
import com.example.gestiondocumentsdemander.queries.dtos.GetAllDocByStatusQueryDTO;
import com.example.gestiondocumentsdemander.queries.dtos.GetAllDocQueryDTO;
import com.example.gestiondocumentsdemander.queries.dtos.GetDocQueryDTO;
import com.example.gestiondocumentsdemander.queries.entities.DocDemander;
import com.example.gestiondocumentsdemander.queries.repositories.DocRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@AllArgsConstructor
@Slf4j
public class DocQueryService {
    private final DocRepository docRepository;
    private final QueryUpdateEmitter queryUpdateEmitter;

    @EventHandler
    public void on(DocCreatedEvent docCreatedEvent){
        log.info("***");
        log.info("DemandeDocumentCreatedEventRecieved");
        DocDemander docDemander=new DocDemander();
        docDemander.setDocId(docCreatedEvent.getId());
        docDemander.setFirstName(docCreatedEvent.getFirstName());
        docDemander.setLastName(docCreatedEvent.getLastName());
        docDemander.setInstituteName(docCreatedEvent.getInstituteName());
        docDemander.setPost(docCreatedEvent.getPost());
        docDemander.setStartDate(docCreatedEvent.getStartDate());
        docDemander.setEndDate(docCreatedEvent.getEndDate());
        docDemander.setTypeDoc((docCreatedEvent.getTypeDoc()));
        docDemander.setStatus(docCreatedEvent.getStatus());
        docDemander.setFilePath(docCreatedEvent.getFilePath());
        docDemander.setAdress(docCreatedEvent.getAdress());
        docDemander.setContractType(docCreatedEvent.getContractType());
        docDemander.setSalary(docCreatedEvent.getSalary());
        docDemander.setSupervisorName(docCreatedEvent.getSupervisorName());
        docDemander.setWorkingHours(docCreatedEvent.getWorkingHours());
        docDemander.setMonth(docCreatedEvent.getMonth());
        docDemander.setYear(docCreatedEvent.getYear());
        docDemander.setDetails(docCreatedEvent.getDetails());
        docRepository.save(docDemander);
    }

    @EventHandler
    public void on(DocUpdatedEvent event){
        log.info("***");
        log.info("DocumentUpdatedEventRecieved");
        DocDemander docDemander = docRepository.findById(event.getId()).get();
        docDemander.setFirstName(event.getFirstName());
        docDemander.setLastName(event.getLastName());
        docDemander.setInstituteName(event.getInstituteName());
        docDemander.setEndDate(event.getEndDate());
        docDemander.setPost(event.getPost());
        docDemander.setStartDate(event.getStartDate());
        docDemander.setEndDate(event.getEndDate());
        docDemander.setTypeDoc(event.getTypeDoc());
        docDemander.setStatus(event.getStatus());
        docDemander.setFilePath((event.getFilePath()));
        docDemander.setAdress(event.getAdress());
        docDemander.setContractType(event.getContractType());
        docDemander.setSalary(event.getSalary());
        docDemander.setSupervisorName(event.getSupervisorName());
        docDemander.setWorkingHours(event.getWorkingHours());
        docDemander.setMonth(event.getMonth());
        docDemander.setYear(event.getYear());
        docDemander.setDetails(event.getDetails());
        docRepository.save(docDemander);
    }
    @EventHandler
    public void on(DocUploadEvent event){
        log.info("***");
        log.info("DocumentUploadEventRecieved");
        DocDemander docDemander = docRepository.findById(event.getId()).get();
        docDemander.setFirstName(event.getFirstName());
        docDemander.setLastName(event.getLastName());
        docDemander.setInstituteName(event.getInstituteName());
        docDemander.setEndDate(event.getEndDate());
        docDemander.setPost(event.getPost());
        docDemander.setStartDate(event.getStartDate());
        docDemander.setEndDate(event.getEndDate());
        docDemander.setTypeDoc(event.getTypeDoc());
        docDemander.setStatus(event.getStatus());
        docDemander.setFilePath((event.getFilePath()));
        docDemander.setAdress(event.getAdress());
        docDemander.setContractType(event.getContractType());
        docDemander.setSalary(event.getSalary());
        docDemander.setSupervisorName(event.getSupervisorName());
        docDemander.setWorkingHours(event.getWorkingHours());
        docDemander.setMonth(event.getMonth());
        docDemander.setYear(event.getYear());
        docDemander.setDetails(event.getDetails());
        docRepository.save(docDemander);
    }
    @QueryHandler
    public DocDemander on (GetDocQueryDTO query) {
        return docRepository.findById(query.getId()).get();
    }

    @QueryHandler
    public List<DocDemander> on(GetAllDocQueryDTO getAllCRAsRequestDTO) {
        return docRepository.findAll();
    }
    @QueryHandler
    public List<DocDemander> getByStatus(GetAllDocByStatusQueryDTO getAllDocByStatusQueryDTO) {
        return docRepository.findByStatus();
    }
}
