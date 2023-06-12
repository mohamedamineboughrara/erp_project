package com.example.gestiondocumentsdemander.queries.controllers;

import com.example.gestiondocumentsdemander.queries.dtos.GetAllDocByStatusQueryDTO;
import com.example.gestiondocumentsdemander.queries.dtos.GetAllDocQueryDTO;
import com.example.gestiondocumentsdemander.queries.dtos.GetDocQueryDTO;
import com.example.gestiondocumentsdemander.queries.entities.DocDemander;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path="/query")
public class DocQueryRestController {
    private QueryGateway queryGateway;

    public DocQueryRestController(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }
    @GetMapping(path="/Document/{id}")
    public DocDemander getDoc(@PathVariable String id){
        return queryGateway.query(new GetDocQueryDTO(id),ResponseTypes.instanceOf(DocDemander.class)).join();
    }
    @GetMapping(path="/AllDocuments")
    public List<DocDemander> getAll(){
        List<DocDemander> reponse=queryGateway.query(new GetAllDocQueryDTO(), ResponseTypes.multipleInstancesOf(DocDemander.class)).join();
        return reponse;
    }
    @GetMapping(path="/AllDocumentByStatus")
    public List<DocDemander> getAllByStatus(){
        List<DocDemander> reponse=queryGateway.query(new GetAllDocByStatusQueryDTO(), ResponseTypes.multipleInstancesOf(DocDemander.class)).join();
        return reponse;
    }

}
