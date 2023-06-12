package com.example.Material.commanApi.commands;

import lombok.Getter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class MaterialCommand {
    @TargetAggregateIdentifier
    @Getter
    private String materialId;
    @Getter
    private String materialName;
    @Getter
    private int quantity;
    @Getter
    private String photo;

    public MaterialCommand(String materialId, String materialName, int quantity,String photo) {
        this.materialId = materialId;
        this.materialName = materialName;
        this.quantity = quantity;
        this.photo = photo;
    }
}
