package com.example.Material.query.Controllers;

import com.example.Material.query.entities.AssignedMaterial;
import com.example.Material.query.entities.Material;
import com.example.Material.query.service.GetAllAssignedForCollab;
import com.example.Material.query.service.GetAllMaterial;
import lombok.AllArgsConstructor;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;
@CrossOrigin(origins = "*")

@RestController
@RequestMapping("/query/material")
@AllArgsConstructor
public class MaterialQueryController {
    private QueryGateway queryGateway;
    @GetMapping("/list")
    public CompletableFuture<List<Material>> accountList(){
        return queryGateway.query(new GetAllMaterial(), ResponseTypes.multipleInstancesOf(Material.class));
    }
    @GetMapping("/{collaborators}")
    public List<AssignedMaterial> materialByCollab(@PathVariable String collaborator) {
        var getAllAssignedForCollab = new GetAllAssignedForCollab(collaborator);

        return queryGateway.query(getAllAssignedForCollab, ResponseTypes.multipleInstancesOf(AssignedMaterial.class)).join();
    }
}
