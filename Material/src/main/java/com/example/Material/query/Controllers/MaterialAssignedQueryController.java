package com.example.Material.query.Controllers;

import com.example.Material.query.entities.AssignedMaterial;
import com.example.Material.query.service.GetAllAssignedForCollab;
import lombok.AllArgsConstructor;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")

@RestController
@RequestMapping("/query/material/assign")
@AllArgsConstructor
public class MaterialAssignedQueryController {
    private QueryGateway queryGateway;

    @GetMapping("/{collaborator}")
    public List<AssignedMaterial> materialByCollab(@PathVariable String collaborator) {
        var getAllAssignedForCollab = new GetAllAssignedForCollab(collaborator);

        return queryGateway.query(getAllAssignedForCollab, ResponseTypes.multipleInstancesOf(AssignedMaterial.class)).join();
    }
}
