package com.oga.leave.queries.controllers;

import com.oga.leave.queries.dtos.GetLeaveQueryDTO;
import com.oga.leave.queries.dtos.LeaveResponseDTO;
import com.oga.leave.queries.entities.Leave;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping(path = "/query")
public class LeaveQueryRestController {
    private final QueryGateway queryGateway;
    public LeaveQueryRestController(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;

    }
    @GetMapping(path ="/leaves/{id}")
    public LeaveResponseDTO getLeave(@PathVariable String id) {
        GetLeaveQueryDTO queryDTO = new GetLeaveQueryDTO();
        queryDTO.setLeaveId(id);
        return  queryGateway.query(queryDTO, LeaveResponseDTO.class).join();

    }
    @GetMapping()
    public List<Leave> leaveList(){
        return queryGateway.query((new GetLeaveQuery()), ResponseTypes.multipleInstancesOf(Leave.class)).join();

    }


}
