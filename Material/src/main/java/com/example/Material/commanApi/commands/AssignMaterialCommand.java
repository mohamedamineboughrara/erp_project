package com.example.Material.commanApi.commands;

import lombok.Getter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class AssignMaterialCommand {

    @Getter
    @TargetAggregateIdentifier
    private String id;

    @Getter
    private String materialId;

    @Getter
    private String materialName;

    @Getter
    private int quantity;

    @Getter
    private String collaborator;

    public AssignMaterialCommand(String id, String materialId, String materialName, int quantity, String collaborator) {
        this.id = id;
        this.materialId = materialId;
        this.materialName = materialName;
        this.quantity = quantity;
        this.collaborator = collaborator;
    }
}
