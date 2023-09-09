package com.oga.interview.queries.controllers;

import com.oga.interview.queries.dtos.GetInterviewQueryDTO;
import com.oga.interview.queries.dtos.InterviewResponseDTO;
import com.oga.interview.queries.entities.Interview;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping(path = "/query")
public class InterviewQueryRestController {
    private QueryGateway queryGateway;
    public InterviewQueryRestController(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;

    }
    @GetMapping(path ="/interviews/{id}")
    public InterviewResponseDTO getInterview(@PathVariable String id) {
        GetInterviewQueryDTO queryDTO = new GetInterviewQueryDTO();
        queryDTO.setInterviewId(id);
        return  queryGateway.query(queryDTO, InterviewResponseDTO.class).join();

    }
    @GetMapping()
    public List<Interview> interviewList(){
        return queryGateway.query((new GetInterviewQuery()), ResponseTypes.multipleInstancesOf(Interview.class)).join();

    }
}
