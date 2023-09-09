package org.oga.gestioncras.queries.controllers;

import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.oga.gestioncras.queries.dtos.GetAllCRAsByStatusQueryDTO;
import org.oga.gestioncras.queries.dtos.GetAllCRAsQueryDTO;
import org.oga.gestioncras.queries.dtos.GetCRAsQueryDTO;
import org.oga.gestioncras.queries.entities.CRAs;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path="/query")
public class CRAsQueryRestController {
    private final QueryGateway queryGateway;

    public CRAsQueryRestController(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }
    @GetMapping(path="/CRAs/{id}")
    public CRAs getCRAs(@PathVariable String id){
        return queryGateway.query(new GetCRAsQueryDTO(id),ResponseTypes.instanceOf(CRAs.class)).join();
    }
    @GetMapping(path="/AllCRAs")
    public List<CRAs> getAll(){
        return queryGateway.query(new GetAllCRAsQueryDTO(), ResponseTypes.multipleInstancesOf(CRAs.class)).join();

    }
    @GetMapping(path="/AllCRAsByStatus")
    public List<CRAs> getAllByStatus(){
        return queryGateway.query(new GetAllCRAsByStatusQueryDTO(), ResponseTypes.multipleInstancesOf(CRAs.class)).join();
    }
}
